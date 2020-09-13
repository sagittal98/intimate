package com.intimate.common.aop;


import com.alibaba.fastjson.JSON;
import com.intimate.common.annotation.Log;
import com.intimate.common.model.RecordMessage;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import com.intimate.common.time.TimeUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;


/***
 * 日志注解的切面类
 */

@Aspect
@Component
public class LogAspect {

    private transient Logger log = Logger.getLogger(getClass());


    /**
     * 拦截具体切面
     */
    @Pointcut(value = "execution(* com.intimate.*.service.impl.*(..))")
    public void getValuePointCut()
    {
        log.info("==================getValuePointCut!=====================");

    }

    /**
     * 切面之前
     */
    @Before("getValuePointCut()")
    public void beforeBase(JoinPoint point){
        System.out.println("5555555555555");
        String method = point.getSignature().getName();
        log.info("【前置通知】the method 【" + method + "】 begins with " + Arrays.asList(point.getArgs()));
    }


    /**
     *
     * 环绕时
     *
     */
    @Around("getValuePointCut()" + "&&args(l)")
    public Object aroundBase(ProceedingJoinPoint point, Log l){
        RecordMessage recordMessage = new RecordMessage();
        Long startTime = System.currentTimeMillis();
        Object object = null;
        try
        {
            /* 记录下当前时间 作为请求起始时间 */
            recordMessage.setRequestTime(TimeUtils.getLongDateString(Calendar.getInstance().getTime()));

            /* 获取请求的信息 */
            getRequestParams(point, recordMessage);

            /* 执行请求的方法 */
            object = point.proceed();

            /* 记录下当前时间 作为响应时间 */
            recordMessage.setResponseTime(TimeUtils.getLongDateString(Calendar.getInstance().getTime()));

            /* 记录响应参数 */
            recordMessage.setResponseParames(object == null ? "" : JSON.toJSONString(object));
        }
        catch (Throwable e)
        {
            log.warn("proceed GW Interface throwable, ", e);
        }
        finally
        {
            Long endTime = System.currentTimeMillis();
            recordMessage.setCostTime(endTime - startTime);
            /* 记录接口日志 */
            log.info(recordMessage.toString());
        }
        return object;
    }

    /**
     * 从切点中解析出该切点对应的方法
     * @param point point
     * @throws ClassNotFoundException
     * @author 洪墨水
     */
    private void getRequestParams(ProceedingJoinPoint point, RecordMessage recordMessage) throws ClassNotFoundException, IOException
    {
        /* 类名 */
        String targetObject = point.getTarget().getClass().getName();
        /* 方法名 */
        String methodName = point.getSignature().getName();

        recordMessage.setTargetObject(targetObject);
        recordMessage.setMethod(methodName);

        Object[] args = point.getArgs();

        Class<?> targetClass = Class.forName(targetObject);

        Method[] methods = targetClass.getMethods();

        StringBuilder requestBuilder = new StringBuilder(0);

        /**
         * 遍历方法 获取能与方法名相同且请求参数个数也相同的方法
         */
        for (Method method : methods)
        {
            if (!method.getName().equals(methodName))
            {
                continue;
            }

            Class<?>[] classes = method.getParameterTypes();

            if (classes.length != args.length)
            {
                continue;
            }

            for (int index = 0; index < classes.length; index++)
            {
                requestBuilder.append(args[index] == null ? "" : JSON.toJSONString(args[index]));
            }

            recordMessage.setRequestParames(requestBuilder.toString());
        }

    }



    /**
     * 切面之后
     */
    @After(value = "getValuePointCut()")
    public void after()
    {
        System.out.println("方法执行结束...");
    }

}


