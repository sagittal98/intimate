package com.intimate.common.interceptor;

import com.intimate.common.model.CheckResult;
import com.intimate.common.token.JwtUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器实现类
 */
public class Interceptor implements HandlerInterceptor {

    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("【日志提醒】进入request请求前身份验证！");
        logger.info("【日志提醒】获取请求名！");
        // todo  token验证
//        获取请求头token
        String token = httpServletRequest.getHeader("Authorization");
        if(token.equals("logon")){
            return true;
        }
        // 验证token
        CheckResult checkResult = JwtUtils.validateJWT(token);
        httpServletRequest.setAttribute("checkResult",checkResult);
        return checkResult.isSuccess();
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("方法执行了！");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("方法结束了！");
    }
}
