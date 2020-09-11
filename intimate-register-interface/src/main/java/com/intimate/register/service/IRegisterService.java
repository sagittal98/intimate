package com.intimate.register.service;

import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;

public interface IRegisterService {

    /**
     * 1. 手机号码注册
     * 2. 微信授权
     * 3. QQ授权
     */
    public Result<String> phoneRegister(SMSInfoModel smsInfoModel);
    // 手机号码检查是否存在
    public Result<SMSInfoModel> phoneIsExist(String phoneNumber);
    // 发送短信验证码
    public Result<SMSInfoModel> sendPhoneVerify(SMSInfoModel smsInfoModel);
}
