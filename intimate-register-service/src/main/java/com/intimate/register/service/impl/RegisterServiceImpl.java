package com.intimate.register.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.intimate.common.authorization.IWeChatAuthorization;
import com.intimate.common.authorization.impl.WeChatAuthorization;
import com.intimate.common.enums.RedisKeySignEnum;
import com.intimate.common.model.*;
import com.intimate.common.redis.IRedisTemplate;
import com.intimate.common.redis.impl.RedisTemplateImpl;
import com.intimate.common.regular.RegUtils;
import com.intimate.common.sms.ISendMessages;
import com.intimate.common.sms.impl.SendMessages;
import com.intimate.common.token.JwtUtils;
import com.intimate.dao.UserMapper;
import com.intimate.pojo.User;
import com.intimate.register.service.IRegisterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service(version = "0.0.1")
public class RegisterServiceImpl implements IRegisterService {

    // 日志
    private Logger logger = Logger.getLogger(getClass());
    // 微信授权接口
    private IWeChatAuthorization weChatAuthorization = new WeChatAuthorization();
    //    redis缓存
    private IRedisTemplate<String,Object> redisTemplate = new RedisTemplateImpl<>();
    @Autowired
    private UserMapper userMapper;


    /**
     * 手机号码注册
     * @param smsInfoModel  用户注册信息
     * @return 返回参数
     */
    @Override
    public Result<String> phoneRegister(SMSInfoModel smsInfoModel) {
        logger.info("【日志提醒】进入用户注册逻辑!");
        // 手机号码检查
        if (!RegUtils.checkPhone(smsInfoModel.getPhone())){
            return Result.error(225);
        }
        // 验证手机号码
        if (!smsInfoModel.isCheckPhoneNumber()){
            logger.info("【日志提醒】手机号未能通过!退出注册逻辑，返回结果！");
            Result.error(225);
        }
        if (!smsInfoModel.isVerifyCode()){
            logger.info("【日志提醒】验证码未能通过!退出注册逻辑，返回结果！");
            return Result.error(215);
        }
        // 2. 短信验证码是否验证成功
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
        // 用户权限级别  默认550  第一位为用户类型，第二位为用户权限，第三位为用户等级
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
            logger.info("【日志提醒】准备写入数据库！(写入数据库并返回用户信息！)");
            int i  = userMapper.insertSelective(user);
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
        User saveUserInfo = null;
        try {
            // 获取用户信息
            saveUserInfo = userMapper.selectByPhoneNumber(user.getPhone());
        }catch (
                Exception e
        ){
            logger.info("【日志提醒】查询用户信息失败！未能缓存成功！");
        }
        // 将手机已注册放入缓存
        try {
            redisTemplate.boundValueOperations( RedisKeySignEnum.signInfo(1001) + userInfo.getPhone()).set(true);
            // 保证saveUserInfo 不等于null  否则不执行
            assert saveUserInfo != null;
            redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002)+saveUserInfo.getUserId()).set(saveUserInfo);
            logger.info("【日志提醒】缓存成功！");
        }catch (Exception e){
            logger.info("【日志提醒】缓存失败！");
        }
        // 4. 返回结果
        logger.info("【日志提醒】退出注册逻辑，返回结果！");
        return Result.success(token,216);
    }

    /**
     * 发送短信验证码
     */
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
            logger.info("【日志提醒】缓存验证码！过期时间"+ smsInfoModel.getMinute() +"分钟！");
            logger.info("【日志提醒】获取手机号码  phone = " + smsInfoModel.getPhone());
            try {
                if (!smsInfoModel.getPhone().isEmpty()){
                    redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1001) +smsInfoModel.getPhone()).set(smsInfoModel.getCode(),Long.parseLong(smsInfoModel.getMinute()), TimeUnit.MINUTES);
                }else {
                    Result.error(228);
                }
                logger.info("【日志提醒】缓存成功！删除验证码");
            }catch (Exception e){
                logger.info("【日志提醒】缓存失败！删除验证码");
                Result.error(227);
            }
            return Result.success(smsInfoModel,213);
        }else {
            logger.info("【日志提醒】失败发送，退出发送逻辑，返回结果！");
            return Result.error(214);
        }
    }

    /**
     * 微信授权
     * @param   js_code js code
     * @param encryptedData  bianma
     * @param iv  加密
     * @return  结果 String
     */

    @Override
    public Result<String> weChatAuthorization(String js_code,String encryptedData,String iv,Integer userId) {
        logger.info("【日志提醒】进入授权开始！");
        logger.info("【日志提醒】开始获取sessionKey");
        JSONObject openidInfo = null;
        try {
            openidInfo = weChatAuthorization.getOpenidInfo(js_code);
            logger.info("日志提醒】微信授权获取openid信息: openidInfo = " + openidInfo.toJSONString());
        } catch (Exception e) {
            logger.info("【日志提醒】获取sessionKey失败！");
            return Result.error(229);
        }
        logger.info("【日志提醒】开始获取weChatUserInfo");
        JSONObject weChatUserInfo = null;
        try {
            weChatUserInfo = weChatAuthorization.getWeChatUserInfo(encryptedData, openidInfo.getString("session_key"), iv);
            logger.info("日志提醒】获取微信用户信息: weChatUserInfo = " + weChatUserInfo.toJSONString());
        }catch (Exception e){
            logger.info("【日志提醒】获取微信用户信息失败！");
            return Result.error(230);
        }
        logger.info("【日志提醒】将用户信息写入模板！");
        WeChatAuthorizationModel weChatAuthorizationModel = new WeChatAuthorizationModel(weChatUserInfo);
        logger.info("【日志提醒】将用户信息写入数据库和redis！");
        // 1. 获取redis用户信息
        // 2. openid更新
        // 3. 补充没有的信息
        logger.info("【日志提醒】获取redis用户信息！");
        JSONObject objectUserInfo = (JSONObject)redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002)+userId).get();
        assert objectUserInfo != null;
        User user = new User(objectUserInfo);

        user.setOpenid(weChatAuthorizationModel.getOpenId());
        // TODO   需要真实环境测试具体情况
//        user.setAvatarUrl(weChatAuthorizationModel.getAvatarUrl());
        // 如果有13位数字，则可以更改昵称
        if (user.getNickName().matches("^\\d{13,}$")){
            user.setNickName(weChatAuthorizationModel.getNickName());
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
        logger.info("【日志提醒】开始删除缓存！");
        // 删除缓存
        Boolean delete = redisTemplate.delete(RedisKeySignEnum.signInfo(1002) + userId);
        if (delete){
            logger.info("【日志提醒】修改数据库数据！");
            // 修改数据库数据
            int i = userMapper.updateByPrimaryKeySelective(user);
            if(i == 1) {
                logger.info("【日志提醒】存入缓存！");
                // 存入缓存
                redisTemplate.boundValueOperations(RedisKeySignEnum.signInfo(1002) + userId).set(user);
            }
        }
        logger.info("【日志提醒】退出授权，返回结果！");
        return Result.success(token,231);
    }

    /**
     * QQ授权
     * @param qqAuthorizationModel  QQAuthorizationModel
     * @return String
     */
    @Override
    public Result<String> QQAuthorization(QQAuthorizationModel qqAuthorizationModel) {
        // todo  qq授权逻辑实现
        return null;
    }

    /**
     * 验证手机号码是否存在
     */
    @Override
    public Result<SMSInfoModel> phoneIsExist(String phoneNumber){
        logger.info("【日志提醒】进入手机号检测逻辑！");
        SMSInfoModel smsInfoModel = new SMSInfoModel();
        // 检查手机号码是否正确
        if (!RegUtils.checkPhone(phoneNumber)){
            return Result.error(225);
        }
        smsInfoModel.setPhone(phoneNumber);
        logger.info("【日志提醒】获取手机号：" + phoneNumber);
        // 1. 通过手机号码查询  返回结果
//        // 先查看缓存是否存在
//        if (redisTemplate.hasKey(RedisKeySignEnum.signInfo(1001) + phoneNumber)){
//            return Result.error(211);
//        }
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
