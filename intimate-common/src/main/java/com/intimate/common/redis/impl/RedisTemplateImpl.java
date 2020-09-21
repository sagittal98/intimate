package com.intimate.common.redis.impl;

import com.intimate.common.redis.IRedisTemplate;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;


@Service
public class RedisTemplateImpl<K,V> extends RedisTemplate<K,V> implements IRedisTemplate<K,V>{

    private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();;
    private RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();


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

//  工厂
    private void factory(){
        setConnectionFactory(connectionFactory());
        afterPropertiesSet();
        //        序列化为字符串
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        setKeySerializer(stringRedisSerializer);
        setStringSerializer(stringRedisSerializer);
        setDefaultSerializer(stringRedisSerializer);
        setHashKeySerializer(stringRedisSerializer);
        setValueSerializer(stringRedisSerializer);
    }





    @Override
    public BoundZSetOperations<K, V> boundZSetOperations(K key) {
        factory();
        return super.boundZSetOps(key);
    }

    @Override
    public BoundValueOperations<K, V> boundValueOperations(K key) {
        factory();
        return super.boundValueOps(key);
    }

    @Override
    public BoundGeoOperations<K, V> boundGeoOperations(K key) {
        factory();
        return super.boundGeoOps(key);
    }

    @Override
    public <HK, HV> BoundHashOperations<K, HK, HV> boundHashOperations(K key) {
        factory();
        return super.boundHashOps(key);
    }

    @Override
    public BoundListOperations<K, V> boundListOperations(K key) {
        factory();
        return super.boundListOps(key);
    }

    @Override
    public BoundSetOperations<K, V> boundSetOperations(K key) {
        factory();
        return super.boundSetOps(key);
    }

    @Override
    public <HK, HV> BoundStreamOperations<K, HK, HV> boundStreamOperations(K key) {
        factory();
        return boundStreamOps(key);
    }
}
