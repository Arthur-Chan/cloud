package com.example.springcloudconsulproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <p>
 * Author     : Chan
 * CreateDate : 2018/8/7 22:53
 * Description:
 * </p>
 */
@Component
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Set<String> keys() {
        return redisTemplate.keys("*");
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
