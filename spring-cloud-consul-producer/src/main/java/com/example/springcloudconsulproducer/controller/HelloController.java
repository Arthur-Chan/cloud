package com.example.springcloudconsulproducer.controller;

import com.example.springcloudconsulproducer.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/getRedis")
    public Object getRedis(@RequestParam("stringKey") String key) {
        return redisService.get(key);
    }
}