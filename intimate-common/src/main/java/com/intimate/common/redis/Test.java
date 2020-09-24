package com.intimate.common.redis;

import com.intimate.common.redis.impl.RedisTemplateImpl;
import org.springframework.beans.factory.annotation.Autowired;


public class Test {


    private static IRedisTemplate<String,Object> redisTemplate = new RedisTemplateImpl<>();

    public static void main(String[] args) {
        Object name = redisTemplate.boundValueOperations("name").get();
        System.out.println(name);

    }

}
