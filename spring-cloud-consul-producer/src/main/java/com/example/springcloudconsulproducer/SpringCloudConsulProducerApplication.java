package com.example.springcloudconsulproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConsulProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulProducerApplication.class, args);
    }
}
