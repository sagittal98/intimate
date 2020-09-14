package com.intimate.login.controller;


import com.intimate.common.model.CheckResult;
import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.common.model.UserInfo;
import com.intimate.common.token.JwtUtils;
import com.intimate.login.service.ILoginService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("/login")
public class LoginController {
    // 日志
    private final Logger logger = Logger.getLogger(getClass());

    private SMSInfoModel smsInfoModel = new SMSInfoModel();


    @Autowired
    private ILoginService loginService;

    /**
     * 手机号码检查
     * @param req  请求内容
     * @return  返回结果
     */
    @RequestMapping("/checkPhoneNumber")
    @ResponseBody
    public Result<Boolean> checkPhoneNumber(HttpServletRequest req){
        logger.info("【日志提醒】进入手机号码检查请求！");
        String phoneNumber = req.getParameter("phoneNumber");
        logger.info("【日志提醒】获取手机号码：phoneNumber = " + phoneNumber);
        return loginService.phoneIsExist(phoneNumber);
    }

    /**
     * 手机验证码发送
     * @param req  请求
     * @return 返回参数
     */
    @RequestMapping("/sendVerifyCode")
    @ResponseBody
    public Result<SMSInfoModel> sendVerifyCode(HttpServletRequest req){
        logger.info("【日志提醒】进入sendVerifyCode请求！");
        String phoneNumber = req.getParameter("phoneNumber");
        smsInfoModel.setPhone(phoneNumber);
        Integer type = Integer.valueOf(req.getParameter("type"));
        smsInfoModel.setType(type);
        boolean isCheckPhoneNumber = Boolean.parseBoolean(req.getParameter("isCheckPhoneNumber"));
        smsInfoModel.setCheckPhoneNumber(isCheckPhoneNumber);
        logger.info("【日志提醒】获取参数：smsInfoModel = " + smsInfoModel.toString());
        return loginService.sendPhoneVerify(smsInfoModel);
    }

    /**
     * 登录
     * @param req
     * @return
     */
    @RequestMapping("/toLogin")
    @ResponseBody
    public Result<String> toLogin(HttpServletRequest req){
        logger.info("【日志提醒】toLogin！");
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
        return loginService.login(smsInfoModel);
    }

    /**
     * 更新token
     * @param req
     * @return
     */
    @RequestMapping("/tokenVerify")
    @ResponseBody
    public Result<String> tokenVerify(HttpServletRequest req){
        logger.info("【日志提醒】即将更新token！");
        CheckResult checkResult = (CheckResult) req.getAttribute("checkResult");
        logger.info("【日志提醒】获取checkResult = "  +checkResult);
        String sub = String.valueOf(checkResult.getClaims().get("sub"));
        logger.info("【日志提醒】获取sub = " + sub);
        // 有效期限6个月
        long ttlMillis = 6 * 30 * 24 * 60 * 60 * 1000L;
        // 唯一标识
        String jti = "hydrogen_honey" ;
        // 生成token
        logger.info("【日志提醒】开始写入token");
        String token = JwtUtils.createJWT(jti, sub, ttlMillis);
        logger.info("【日志提醒】token写入成功！token = " + token);
        // 4. 返回结果
        logger.info("【日志提醒】退出注册逻辑，返回结果！");
        return Result.success(token,216);
    }

}
