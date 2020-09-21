package com.intimate.common.redis;

import org.springframework.data.redis.core.*;

import java.util.List;

public interface IRedisTemplate<K,V>{

    BoundZSetOperations<K, V> boundZSetOperations(K key);
    BoundValueOperations<K, V> boundValueOperations(K key);
    BoundGeoOperations<K, V> boundGeoOperations(K key);
    <HK, HV> BoundHashOperations<K, HK, HV> boundHashOperations(K key);
    BoundListOperations<K, V> boundListOperations(K key);
    BoundSetOperations<K, V> boundSetOperations(K key);
    <HK, HV> BoundStreamOperations<K, HK, HV> boundStreamOperations(K key);

}
