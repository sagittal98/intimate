package com.intimate.register.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.register.service.IRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Reference
    private IRegisterService registerService;

    private SMSInfoModel smsInfoModel = new SMSInfoModel();

    @RequestMapping("/checkPhone")
    @ResponseBody
    public Result<SMSInfoModel> checkPhone(HttpServletRequest req){
        String phoneNumber = String.valueOf(req.getAttribute("phoneNumber"));
        return registerService.phoneIsExist(phoneNumber);
    }

    @RequestMapping("/sendCode")
    @ResponseBody
    public Result<SMSInfoModel> sendCode(HttpServletRequest req){
        // 需要手机号/验证码/类型
        String phoneNumber = String.valueOf(req.getAttribute("phoneNumber"));
        smsInfoModel.setPhone(phoneNumber);
        Integer type = (Integer)req.getAttribute("type");
        smsInfoModel.setType(type);
        boolean isCheckPhoneNumber = (boolean) req.getAttribute("isCheckPhoneNumber");
        smsInfoModel.setCheckPhoneNumber(isCheckPhoneNumber);
        return registerService.sendPhoneVerify(smsInfoModel);
    }

    @RequestMapping("/logon")
    @ResponseBody
    public Result<String> logon(HttpServletRequest req){
        // 需要手机号/验证码/类型/密码/验证码情况
        String phoneNumber = String.valueOf(req.getAttribute("phoneNumber"));
        smsInfoModel.setPhone(phoneNumber);
        Integer type = (Integer)req.getAttribute("type");
        smsInfoModel.setType(type);
        String password = String.valueOf(req.getAttribute("password"));
        smsInfoModel.setPassword(password);
        boolean isCheckPhoneNumber = (boolean) req.getAttribute("isCheckPhoneNumber");
        smsInfoModel.setCheckPhoneNumber(isCheckPhoneNumber);
        boolean isVerifyCode = (boolean)req.getAttribute("isVerifyCode");
        smsInfoModel.setVerifyCode(isVerifyCode);
        return registerService.phoneRegister(smsInfoModel);
    }


}
