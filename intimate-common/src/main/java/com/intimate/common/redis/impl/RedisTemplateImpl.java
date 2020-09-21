package com.intimate.common.redis.impl;

import com.intimate.common.redis.IRedisTemplate;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisTemplateImpl implements IRedisTemplate {

    private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();;
    private RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
    private RedisTemplate<Object, Object> template = new RedisTemplate<>();



    //    连接池配置
    private JedisPoolConfig poolConfig(){
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
        return jedisPoolConfig;
    }

    private RedisClusterConfiguration clusterConfig(){

//        节点
        List<RedisNode> list = new ArrayList<>();
        list.add(new RedisNode("139.155.45.210",7001));
        list.add(new RedisNode("139.155.8.199",7002));
        list.add(new RedisNode("139.155.70.76",7003));
        list.add(new RedisNode("139.155.45.210",7004));
        list.add(new RedisNode("139.155.8.199",7005));
        list.add(new RedisNode("139.155.70.76",7006));
        redisClusterConfiguration.setMaxRedirects(6);
        redisClusterConfiguration.setClusterNodes(list);
//        密码
        redisClusterConfiguration.setPassword("hydrogenhoney@root");
        return redisClusterConfiguration;
    }
//    链接
    private JedisConnectionFactory connectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(clusterConfig(),poolConfig());
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
//    创建模板
    private RedisTemplate<Object, Object> redisTemplate(){
        template.setConnectionFactory(connectionFactory());
        template.afterPropertiesSet();
//        设置序列化
        //        序列化为字符串
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setStringSerializer(stringRedisSerializer);
        template.setDefaultSerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setValueSerializer(stringRedisSerializer);
        return template;
    }

    @Override
    public boolean delete(@NotBlank(message = "key值不能为空！") String key) {
        return redisTemplate().delete(key);
    }

    @Override
    public boolean delete(@NotEmpty(message = "keys集合不能为空！") String... keys) {
        return redisTemplate().delete(keys);
    }

    @Override
    public boolean expire(@NotBlank(message = "key值不能为空！") String key, @NotNull(message = "time不为空！")long time) {
        return redisTemplate().expire(key, time, TimeUnit.MINUTES);
    }

    @Override
    public long getExpire(@NotBlank(message = "key值不能为空！") String key) {
        return redisTemplate().getExpire(key);
    }

    @Override
    public boolean hasKey(@NotBlank(message = "key值不能为空！") String key) {
        return redisTemplate().hasKey(key);
    }
}
