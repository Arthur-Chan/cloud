package com.example.springcloudconsulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/call")
    public Object call() {
        Map<String, Object> map = new HashMap<>();
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        map.put("serviceUri", serviceInstance.getUri());
        map.put("serviceId", serviceInstance.getServiceId());
        Object callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", Object.class);
        map.put("invokeResult", callServiceResult);
        return map;
    }

}