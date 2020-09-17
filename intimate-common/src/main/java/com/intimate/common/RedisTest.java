package com.intimate.common;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisTest {

    public static void main(String[] args) throws IOException {
        // 创建并填充节点信息
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("139.155.45.210", 7001));
        nodes.add(new HostAndPort("139.155.8.199", 7002));
        nodes.add(new HostAndPort("139.155.70.76", 7003));
        nodes.add(new HostAndPort("139.155.45.210", 7004));
        nodes.add(new HostAndPort("139.155.8.199", 7005));
        nodes.add(new HostAndPort("139.155.70.76", 7006));

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxTotal(30);
        poolConfig.setNumTestsPerEvictionRun(1024);
        poolConfig.setTimeBetweenEvictionRunsMillis(30000);
        poolConfig.setMinEvictableIdleTimeMillis(1800000);
        poolConfig.setSoftMinEvictableIdleTimeMillis(10000);
        poolConfig.setMaxWaitMillis(1500);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setBlockWhenExhausted(false);

        // 创建JedisCluster对象
        JedisCluster jedisCluster = new JedisCluster(nodes,5000,2000,2,"hydrogenhoney@root",poolConfig);
        // 使用jedisCluster操作redis
        String key = "jedisCluster";

        String setResult = jedisCluster.set(key, "hello redis!");
        System.out.println("result1 = " +setResult);
        String getResult = jedisCluster.get(key);
        System.out.println("result2 = " +getResult);

        // 关闭jedisCluster（程序执行完后才能关闭，内部封装了连接池） jedisCluster.close();
        jedisCluster.close();

    }

}
