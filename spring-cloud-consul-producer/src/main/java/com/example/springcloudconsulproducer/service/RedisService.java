package com.example.springcloudconsulproducer.service;

import java.util.Set;

/**
 * <p>
 * Author     : Chan
 * CreateDate : 2018/8/7 22:52
 * Description:
 * </p>
 */
public interface RedisService {


    Set<String> keys();

    String get(String key);
}
