package com.intimate.common.regular;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtils {


    private static final Logger logger = Logger.getLogger(RegUtils.class);

    /**
     * 邮箱验证
     *
     */

    public static boolean checkEmail(String email){
        boolean flag = false;
        logger.info("【日志提醒】开始邮箱验证！");
        try {
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch (Exception e){
            logger.info("【日志提醒】抛出错误：验证邮箱地址错误！ 错误信息：" + e);
        }
        logger.info("【日志提醒】验证结果：" + flag);
        return flag;
    }

    /**
     * 手机号码验证
     */

    public static boolean checkPhone(String phoneNumber){
        boolean flag = false;
        logger.info("【日志提醒】开始手机号验证！");
        try{
            Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
//            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m = p.matcher(phoneNumber);
            flag = m.matches();
        }catch(Exception e){
            logger.info("【日志提醒】抛出错误：验证邮箱地址错误！ 错误信息：" + e);
        }
        logger.info("【日志提醒】验证结果：" + flag);
        return flag;
    }

}
