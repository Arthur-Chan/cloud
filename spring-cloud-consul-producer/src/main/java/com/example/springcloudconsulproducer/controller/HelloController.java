package com.example.springcloudconsulproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/hello")
    public Object hello() {
        List<String> keys = new ArrayList<>();
        keys.add("test:1");
        keys.add("test:2");
        keys.add("test:3");
        return redisTemplate.opsForValue().multiGet(keys);
    }
}