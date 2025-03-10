package com.bank.finance.client.infrastructure.output.adapter.client.feign;

import com.bank.finance.client.domain.exception.ServiceClientException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class ClientFeignClientFallbackFactory implements FallbackFactory<ClientFeignClient> {

  @Override
  public ClientFeignClient create(Throwable cause) {
    return id -> {
      if (cause instanceof FeignException.NotFound) {
        log.error("Client not found with ID: {}. Error: {}", id, cause.getMessage());
        return null;
      } else {
        log.error("Error trying to connect to service-client: {}", cause.getMessage());
        throw new ServiceClientException();
      }
    };
  }
}
