package com.intimate.register.controller;


import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.register.service.IRegisterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;


/*
* 1. 手机号检查
* 2. 发送验证码
* 3. 完成注册
* 4. 微信授权
* 5. QQ授权
* */

@Controller
@RequestMapping("/register")
public class RegisterController {
    // 日志
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private IRegisterService registerService;

    private SMSInfoModel smsInfoModel = new SMSInfoModel();

    /**
     *  检查手机号
     * @param req 请求参数  PhoneNumber
     * @return Result<SMSInfoModel>
     */
    @RequestMapping("/checkPhone")
    @ResponseBody
    public Result<SMSInfoModel> checkPhone(HttpServletRequest req){
        logger.info("【日志提醒】进入checkPhone请求！");
        String phoneNumber = req.getParameter("phoneNumber");
        logger.info("【日志提醒】获取参数：phoneNumber = " + phoneNumber);
        return registerService.phoneIsExist(phoneNumber);
    }

    /**
     *  发送验证码
     * @param req 请求参数 SMSInfoModel
     * @return  Result<SMSInfoModel>
     */
    @RequestMapping("/sendCode")
    @ResponseBody
    public Result<SMSInfoModel> sendCode(HttpServletRequest req){
        logger.info("【日志提醒】进入sendCode请求！");
        String phoneNumber = req.getParameter("phoneNumber");
        smsInfoModel.setPhone(phoneNumber);
        Integer type = Integer.valueOf(req.getParameter("type"));
        smsInfoModel.setType(type);
        boolean isCheckPhoneNumber = Boolean.parseBoolean(req.getParameter("isCheckPhoneNumber"));
        smsInfoModel.setCheckPhoneNumber(isCheckPhoneNumber);
        logger.info("【日志提醒】获取参数：smsInfoModel = " + smsInfoModel.toString());
        return registerService.sendPhoneVerify(smsInfoModel);
    }

    /**
     * 注册
     * @param req 请求参数  SmsInfoModel
     * @return Result<token>
     */
    @RequestMapping("/logon")
    @ResponseBody
    public Result<String> logon(HttpServletRequest req){
        logger.info("【日志提醒】进入logon请求！");
        // 需要手机号/验证码/类型/密码/验证码情况
        String phoneNumber = req.getParameter("phoneNumber");
        smsInfoModel.setPhone(phoneNumber);
        Integer type = Integer.valueOf(req.getParameter("type"));
        smsInfoModel.setType(type);
        String password = req.getParameter("password");
        smsInfoModel.setPassword(password);
        boolean isCheckPhoneNumber = Boolean.parseBoolean(req.getParameter("isCheckPhoneNumber"));
        smsInfoModel.setCheckPhoneNumber(isCheckPhoneNumber);
        boolean isVerifyCode = Boolean.parseBoolean(req.getParameter("isVerifyCode"));
        smsInfoModel.setVerifyCode(isVerifyCode);
        logger.info("【日志提醒】获取参数：smsInfoModel = " + smsInfoModel.toString());
        return registerService.phoneRegister(smsInfoModel);
    }


    /**
     *  微信授权
     * @param req  请求参数
     * @return  Result<>
     */
    @RequestMapping("/wechatAuthorization")
    @ResponseBody
    public Result wechatAuthorization(HttpServletRequest req){

        return null;
    }


}
