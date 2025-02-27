package com.bank.finance;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.bank")
public class ServiceFinanceApplication {

  @Generated
  public static void main(String... args) {
    SpringApplication.run(ServiceFinanceApplication.class);
  }
}
