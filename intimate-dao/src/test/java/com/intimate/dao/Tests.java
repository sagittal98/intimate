package com.intimate.dao;


import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring/spring-dao.xml"})
//@ContextConfiguration({"classpath:spring/spring-*.xml"})

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class Tests {

    @Autowired
    private RedisTemplate<String,Objects> redisTemplate;


    @Test
    public void test(){
//        List<Province> provinceList = provinceMapper.selectByExample(null);
//        System.out.println(Arrays.toString(provinceList.toArray()));
//
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.afterPropertiesSet();
//
//        redisTemplate.afterPropertiesSet();


        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        assert connectionFactory != null;
        System.out.println(connectionFactory.getClusterConnection().getClientList());

        Object name = redisTemplate.boundValueOps("sagittal").get();
        System.out.println(name);

    }


    @Test
    public void test1(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setNumTestsPerEvictionRun(1024);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(1800000);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(10000);
        jedisPoolConfig.setMaxWaitMillis(1500);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setBlockWhenExhausted(false);

        List<RedisNode> list = new ArrayList<>();
        list.add(new RedisNode("139.155.45.210",7001));
        list.add(new RedisNode("139.155.8.199",7002));
        list.add(new RedisNode("139.155.70.76",7003));
        list.add(new RedisNode("139.155.45.210",7004));
        list.add(new RedisNode("139.155.8.199",7005));
        list.add(new RedisNode("139.155.70.76",7006));
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        redisClusterConfiguration.setMaxRedirects(6);
        redisClusterConfiguration.setClusterNodes(list);
        redisClusterConfiguration.setPassword("hydrogenhoney@root");


        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);
        jedisConnectionFactory.afterPropertiesSet();


        RedisTemplate<Object, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        objectObjectRedisTemplate.afterPropertiesSet();


        Object sagittal = objectObjectRedisTemplate.boundValueOps("sagittal").get();
        System.out.println(sagittal);
        Object name = objectObjectRedisTemplate.boundValueOps("name").get();
        System.out.println("name = " + name);
//        序列化为字符串
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        序列化为字节码
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
//        序列化为json
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        objectObjectRedisTemplate.setKeySerializer(stringRedisSerializer);
        objectObjectRedisTemplate.setStringSerializer(stringRedisSerializer);
        objectObjectRedisTemplate.setDefaultSerializer(stringRedisSerializer);
        objectObjectRedisTemplate.setHashKeySerializer(stringRedisSerializer);
        objectObjectRedisTemplate.setValueSerializer(stringRedisSerializer);

    }
}
