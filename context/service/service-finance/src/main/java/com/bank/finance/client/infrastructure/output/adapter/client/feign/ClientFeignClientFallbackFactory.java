package com.bank.finance.client.infrastructure.output.adapter.client.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class ClientFeignClientFallbackFactory implements FallbackFactory<ClientFeignClient> {

  @Override
  public ClientFeignClient create(Throwable cause) {
    return id -> {
      log.error("Error to trying connect in service-client: { }", cause);
      return null;
    };
  }
}
