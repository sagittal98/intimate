package com.intimate.common.redis;

import org.springframework.data.redis.core.RedisTemplate;

public interface IRedisTemplate {

//    删除单个key
    boolean delete(String key);
//    删除多个key
    boolean delete(String ... keys);
//    指定key的失效时间
    boolean expire(String key,long time);
//    根据key获取过期时间
    long getExpire(String key);
//    判断key是否存在
    boolean hasKey(String key);

}
