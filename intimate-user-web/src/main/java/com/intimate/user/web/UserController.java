package com.intimate.user.web;


import com.alibaba.fastjson.JSONObject;
import com.intimate.common.model.Result;
import com.intimate.pojo.User;
import com.intimate.user.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;


@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private IUserService userService;

    /**
     * 1. 修改账户信息
     */
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public Result<Boolean> updateUserInfo(HttpServletRequest req){
        logger.info("【日志提醒】进入修改账户操作！");
        // 获取操作用户的权限
        String operatorAuthority = req.getParameter("operatorAuthority");
        logger.info("【日志提醒】获取操作用户的权限：operatorAuthority = " + operatorAuthority);
        // 获取用户信息
        JSONObject userInfo = JSONObject.parseObject(req.getParameter("user"));
        logger.info("【日志提醒】获取需要操作的用户信息：userInfo = " + userInfo.toJSONString());
        User user = new User(userInfo);
        logger.info("【日志提醒】写入user模板：user = " + user.toString());
        return userService.updateUserInfo(operatorAuthority, user);
    }

    /**
     * 2. 修改账户权限
     */
    @RequestMapping("/updateUserAuthorization")
    @ResponseBody
    public Result<Boolean> updateUserAuthorization(HttpServletRequest req){
        logger.info("【日志提醒】进入修改账户权限操作！");
        // 获取操作者的权限
        String operatorAuthority = req.getParameter("operatorAuthority");
        logger.info("【日志提醒】获取操作者的权限:operatorAuthority = " + operatorAuthority);
        // 获取被修改的用户权限
        JSONObject userInfo = JSONObject.parseObject(req.getParameter("user"));
        logger.info("【日志提醒】获取被修改的用户权限: userInfo = " + userInfo.toJSONString());
        User user = new User(userInfo.getLong("userId"), userInfo.getString("authorityLevel"));
        logger.info("【日志提醒】查看被修改者用户信息： user =  "+ user.toString());
        return userService.updateUserAuthorization(operatorAuthority,user);
    }




}
