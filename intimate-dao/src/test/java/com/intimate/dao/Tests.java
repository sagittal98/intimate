package com.intimate.dao;


import com.intimate.common.redis.IRedisTemplate;
import com.intimate.common.redis.impl.RedisTemplateImpl;
import com.intimate.pojo.Province;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import org.springframework.test.context.junit.jupiter.SpringExtension;

//@RunWith(SpringJUnit4ClassRunner.class)
//// 告诉junit spring配置文件
//@ContextConfiguration({"classpath:spring/spring-*.xml"})

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class Tests {
//
//    @Autowired
//    private RedisTemplate<String,Objects> redisTemplate;

    @Autowired
    private ProvinceMapper provinceMapper;

//    @Autowired
//    private RedisTemplateImpl<String,String> redisTemplate;

    @Test
    public void test(){
//        List<Province> provinceList = provinceMapper.selectByExample(null);
//        System.out.println(Arrays.toString(provinceList.toArray()));

//        String name = redisTemplate.boundValueOperations("name").get();
//        System.out.println(name);
    }


    @Test
    public void test1(){
//        String name = redisTemplate.boundValueOperations("name").get();
//        System.out.println(name);
        IRedisTemplate<Object, Object> red = new RedisTemplateImpl<>();
        Object name = red.boundValueOperations("name").get();
        assert name != null;
        System.out.println(name.toString());

    }
}
