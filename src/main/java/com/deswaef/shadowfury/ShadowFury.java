package com.deswaef.shadowfury;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ShadowFury {

    public static void main(String[] args) {
        SpringApplication.run(ShadowFury.class);
    }
}
