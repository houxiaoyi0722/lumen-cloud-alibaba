package com.lumen.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LumenGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumenGatewayApplication.class, args);
    }

}
