package com.lumen.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.lumen")
public class LumenConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumenConsumerApplication.class, args);
    }

}
