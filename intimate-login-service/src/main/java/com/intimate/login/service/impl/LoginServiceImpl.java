package com.intimate.login.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.intimate.common.enums.RedisKeySignEnum;
import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.common.model.UserInfo;
import com.intimate.common.redis.IRedisTemplate;
import com.intimate.common.redis.impl.RedisTemplateImpl;
import com.intimate.common.regular.RegUtils;
import com.intimate.common.sms.ISendMessages;
import com.intimate.common.sms.impl.SendMessages;
import com.intimate.common.token.JwtUtils;
import com.intimate.dao.UserMapper;
import com.intimate.login.service.ILoginService;
import com.intimate.pojo.User;
import com.intimate.pojo.UserExample;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sun.awt.geom.AreaOp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements ILoginService {
    private final Logger logger = Logger.getLogger(getClass());
    //    redis缓存
    private IRedisTemplate<String,Object> redisTemplate = new RedisTemplateImpl<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<Boolean> phoneIsExist(String phoneNumber) {
        logger.info("【日志提醒】进入手机号检测逻辑！");
        logger.info("【日志提醒】获取手机号：" + phoneNumber);
        // 手机号码检查
        if (!RegUtils.checkPhone(phoneNumber)){
            return Result.error(225);
        }
        // 1. 通过手机号码查询  返回结果
        logger.info("【日志提醒】开始数据库查询！");
        // 先从缓存中查找是否存在！ RedisKeySignEnum.signInfo(1001) + phoneNumber
        if (redisTemplate.hasKey(RedisKeySignEnum.signInfo(1001) + phoneNumber)){
            return Result.success(true,218);
        }
        int count = userMapper.checkPhone(phoneNumber);
        logger.info("【日志提醒】查询结果：" + count);
        if (count != 0 ){
            logger.info("【日志提醒】数据库有库存。结束检测逻辑，返回结果！");
            logger.info("【日志提醒】可以登录，退出检测逻辑，返回结果！");
            return Result.success(true,218);
        }else {
            logger.info("【日志提醒】数据库无库存，需要注册。");
            logger.info("【日志提醒】退出检测逻辑，返回结果！");
            return Result.error(219);
        }
    }

    @Override
    public Result<SMSInfoModel> sendPhoneVerify(SMSInfoModel smsInfoModel) {
        logger.info("【日志提醒】进入发送短信验证码逻辑！");
        // 手机号码检查
        if (!RegUtils.checkPhone(smsInfoModel.getPhone())){
            return Result.error(225);
        }
        // 短信接口使用
        ISendMessages sendMessages = new SendMessages();
        // 生成随机验证码  4位
        smsInfoModel.setCode(String.format("%04d", new Random().nextInt(9999)));
        logger.info("【日志提醒】生成4位随机验证码： "+smsInfoModel.getCode());
        // 验证码期限  1分钟
        smsInfoModel.setMinute("1");
        logger.info("【日志提醒】验证码有效期限： "+smsInfoModel.getMinute());
        logger.info("【日志提醒】开始发送验证码！");
        boolean isSuccess = sendMessages.sendVerifyCode(smsInfoModel);
        logger.info("【日志提醒】验证码发送状态： " + isSuccess);
        if (isSuccess){
            logger.info("【日志提醒】成功发送，退出发送逻辑，返回结果！");
            try {
                if (!smsInfoModel.getPhone().isEmpty()){
                    redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1001) +smsInfoModel.getPhone()).set(smsInfoModel.getCode(),Long.parseLong(smsInfoModel.getMinute()), TimeUnit.MINUTES);
                }else {
                    Result.error(228);
                }
                logger.info("【日志提醒】缓存成功！");
            }catch (Exception e){
                logger.info("【日志提醒】缓存失败！");
                Result.error(227);
            }
            return Result.success(smsInfoModel,213);
        }else {
            logger.info("【日志提醒】失败发送，退出发送逻辑，返回结果！");
            return Result.error(214);
        }
    }

    @Override
    public Result<String> login(SMSInfoModel smsInfoModel) {
        logger.info("【日志提醒】进入登录逻辑！");
        // 手机号码检查
        if (!RegUtils.checkPhone(smsInfoModel.getPhone())){
            return Result.error(225);
        }
        // 2. 短信验证码是否验证成功
        if (smsInfoModel.isVerifyCode()){  // 已经成功验证
            logger.info("【日志提醒】已确认验证码正确通过!");
            logger.info("【日志提醒】开始生产token！");
            // 通过手机号查询用户信息
            User user = null;
            try {
                user = userMapper.selectByPhoneNumber(smsInfoModel.getPhone());
            } catch (Exception e){
                return Result.error(221);
            }
            // 生成token
            UserInfo userInfo = new UserInfo();
            userInfo.setAuthorityLevel(user.getAuthorityLevel());
            userInfo.setOpenID(user.getOpenid());
            userInfo.setPhone(user.getPhone());
            logger.info("【日志提醒】token即将写入信息==> " + userInfo.toString());
            // 有效期限6个月
            long ttlMillis = 6 * 30 * 24 * 60 * 60 * 1000L;
            // 唯一标识
            String jti = "hydrogen_honey" ;
            // 生成token
            String token = JwtUtils.createJWT(jti, userInfo.toString(), ttlMillis);
            logger.info("【日志提醒】token写入成功！token = " + token);
            // 4. 返回结果
            logger.info("【日志提醒】退出注册逻辑，返回结果！");
            return Result.success(token,216);
        }else {
            logger.info("【日志提醒】验证码未能通过!退出注册逻辑，返回结果！");
            return Result.error(215);
        }
    }

    /**
     * 生成新的token
     * @param sub 传入token验证
     * @return
     */
    @Override
    public Result<String> tokenVerify(String sub) {
        logger.info("【日志提醒】开始生成新的token");
        // 有效期限6个月
        long ttlMillis = 6 * 30 * 24 * 60 * 60 * 1000L;
        // 唯一标识
        String jti = "hydrogen_honey" ;
        // 生成token
        logger.info("【日志提醒】开始写入token");
        String token = JwtUtils.createJWT(jti, sub, ttlMillis);
        logger.info("【日志提醒】token写入成功！token = " + token);
        // 4. 返回结果
        logger.info("【日志提醒】退出登录逻辑，返回结果！");
        return  Result.success(token,216);
    }

}
