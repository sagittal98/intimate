package com.intimate.register.service;

import com.intimate.common.model.QQAuthorizationModel;
import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.common.model.WeChatAuthorizationModel;

public interface IRegisterService {

    /**
     * 1. 手机号码注册
     * 2. 微信授权
     * 3. QQ授权
     */
    // 通过手机号码注册
     Result<String> phoneRegister(SMSInfoModel smsInfoModel);
    // 手机号码检查是否存在
     Result<SMSInfoModel> phoneIsExist(String phoneNumber);
    // 发送短信验证码
     Result<SMSInfoModel> sendPhoneVerify(SMSInfoModel smsInfoModel);
    // 通过微信授权  获取用户信息  并缓存在redis中  更新token
    Result<String> weChatAuthorization(String js_code,String encryptedData,String iv,Integer userId);
    // 通过QQ授权
    Result<String> QQAuthorization(QQAuthorizationModel qqAuthorizationModel);
}
