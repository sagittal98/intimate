package com.intimate.register.service.impl;

import com.alibaba.druid.filter.AutoLoad;
import com.alibaba.dubbo.config.annotation.Service;
import com.intimate.common.annotation.Log;
import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.common.model.UserInfo;
import com.intimate.common.sms.ISendMessages;
import com.intimate.common.sms.impl.SendMessages;
import com.intimate.common.token.JwtUtils;
import com.intimate.dao.UserMapper;
import com.intimate.pojo.User;
import com.intimate.register.service.IRegisterService;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Random;


@Service
public class RegisterServiceImpl implements IRegisterService {

    // 日志
    private Logger logger = Logger.getLogger(getClass());



    @Autowired
    private UserMapper userMapper;

    /**
     * 手机号码注册
     * @param smsInfoModel  用户注册信息
     * @return 返回参数
     */
    @Log(name = "phoneRegister")
    public Result<String> phoneRegister(SMSInfoModel smsInfoModel) {
        logger.info("【日志提醒】进入用户注册逻辑!");
        // 2. 短信验证码是否验证成功
        if (smsInfoModel.isVerifyCode()){  // 已经成功验证
            logger.info("【日志提醒】已确认验证码正确通过!");
            // 3. 写入数据库
            User user = new User();
            // 手机号
            user.setPhone(smsInfoModel.getPhone());
            // 密码
            user.setPassword(smsInfoModel.getPassword());
            // 是否检查手机号
            user.setIsPhoneCheck(smsInfoModel.isCheckPhoneNumber());
            long getCurrentTime = System.currentTimeMillis();
            Date date = new Date(getCurrentTime);
            // 注册日期
            user.setRegisterDate(date);
            // 用户权限级别  默认550
            user.setAuthorityLevel("550");
            // 最后登录时间
            user.setLastLoginTime(date);
            // 用户名不存在 则使用时间戳作为用户名
            user.setNickName(String.valueOf(System.currentTimeMillis()));
            // 用户头像  默认地址  因非空控制
            user.setAvatarUrl("www.baidu.com");
            logger.info("【日志提醒】收集到用户信息==> " + user.toString());
            // 插入数据库
            try {
                logger.info("【日志提醒】准备写入数据库！");
                userMapper.insert(user);
                logger.info("【日志提醒】成功写入数据库！");
            }catch (Exception e){
                System.out.println(e.getMessage());
                logger.debug("【日志提醒】写入数据库失败！原因：" + e.getMessage());
                // 插入失败
                return Result.error(217);
            }
            logger.info("【日志提醒】开始生产token！");
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
     * 发送短信验证码
     */
    @Log(name = "sendPhoneVerify")
    public Result<SMSInfoModel> sendPhoneVerify(SMSInfoModel smsInfoModel) {
        logger.info("【日志提醒】进入发送短信验证码逻辑！");
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
            return Result.success(smsInfoModel,213);
        }else {
            logger.info("【日志提醒】失败发送，退出发送逻辑，返回结果！");
            return Result.error(214);
        }
    }

    /**
     * 验证手机号码是否存在
     */
    @Log(name = "phoneIsExist")
    public Result<SMSInfoModel> phoneIsExist(String phoneNumber){
        logger.info("【日志提醒】进入手机号检测逻辑！");
        SMSInfoModel smsInfoModel = new SMSInfoModel();
        smsInfoModel.setPhone(phoneNumber);
        logger.info("【日志提醒】获取手机号：" + phoneNumber);
        // 1. 通过手机号码查询  返回结果
        logger.info("【日志提醒】开始数据库查询！");
        int count = userMapper.checkPhone(phoneNumber);
        logger.info("【日志提醒】查询结果：" + count);
        if (count != 0 ){
            logger.info("【日志提醒】数据库有库存。结束检测逻辑，返回结果！");
            smsInfoModel.setCheckPhoneNumber(false);
            logger.info("【日志提醒】修改手机检测状态！");
            logger.info("【日志提醒】查看修改数据：" + smsInfoModel.toString());
            logger.info("【日志提醒】不可以注册，退出检测逻辑，返回结果！");
            return Result.error(211);
        }else {
            logger.info("【日志提醒】数据库无库存，可以注册。");
            smsInfoModel.setCheckPhoneNumber(true);
            logger.info("【日志提醒】修改手机检测状态！");
            logger.info("【日志提醒】查看修改数据：" + smsInfoModel.toString());
            logger.info("【日志提醒】可以注册，退出检测逻辑，返回结果！");
            return Result.success(smsInfoModel,212);
        }
    }

}
