package com.intimate.register.service.impl;


import com.intimate.common.model.Result;
import com.intimate.common.model.SMSInfoModel;
import com.intimate.register.service.IRegisterService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath*:spring/spring-*.xml"})
public class Tests {

    @Autowired
    private IRegisterService registerService;

    @Test
    public void test1(){
        Result<SMSInfoModel> smsInfoModelResult = registerService.phoneIsExist("17364831501");
        System.out.println(smsInfoModelResult.toString());
    }


}
