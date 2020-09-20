package com.intimate.dao;


import com.intimate.pojo.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
//@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class Tests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void test(){
//        List<Province> provinceList = provinceMapper.selectByExample(null);
//        System.out.println(Arrays.toString(provinceList.toArray()));
    }


    @Test
    public void test1(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
        System.out.println("hello world");
    }
}
