package com.lumen.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author xiaoy
 */
@SpringBootApplication(scanBasePackages = {"com.lumen"})
public class LumenAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumenAuthApplication.class, args);
    }

}
