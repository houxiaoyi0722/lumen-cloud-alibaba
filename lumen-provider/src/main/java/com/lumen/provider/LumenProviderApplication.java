package com.lumen.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaoy
 */
@SpringBootApplication(scanBasePackages = {"com.lumen"})
@EnableDiscoveryClient
public class LumenProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumenProviderApplication.class, args);
    }

}
