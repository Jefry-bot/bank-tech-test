package com.bank.notification;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.bank")
public class ServiceNotificationApplication {

    @Generated
    public static void main(String... args) {
        SpringApplication.run(ServiceNotificationApplication.class);
    }
} 