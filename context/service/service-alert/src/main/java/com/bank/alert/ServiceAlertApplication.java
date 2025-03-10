package com.bank.alert;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.bank")
public class ServiceAlertApplication {

    @Generated
    public static void main(String... args) {
        SpringApplication.run(ServiceAlertApplication.class);
    }
} 