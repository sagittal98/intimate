package com.intimate.login.service;


import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;

/**
 * 所有登录走此接口
 */
public interface ILoginService {
    /**
     * 验证手机号码存在否
     * @param phoneNumber  传入手机号码
     * @return  返回结果值
     */
    Result<Boolean> phoneIsExist(String phoneNumber);

    /**
     * 发送验证码
     * @param smsInfoModel 传入手机号码验证
     * @return  发送结果反馈
     */
    Result<SMSInfoModel> sendPhoneVerify(SMSInfoModel smsInfoModel);

    /**
     * 登录
     * @param smsInfoModel  传入验证情况
     * @return 返回新的token
     */
    Result<String> login(SMSInfoModel smsInfoModel);

    /**
     * token 验证
     * @param token 传入token验证
     * @return 返回新的token
     */
    Result<String> tokenVerify(String token);
}
