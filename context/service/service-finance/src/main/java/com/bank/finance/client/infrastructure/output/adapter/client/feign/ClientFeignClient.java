package com.bank.finance.client.infrastructure.output.adapter.client.feign;

import com.bank.common.adapter.input.web.dto.Response;
import com.bank.finance.client.infrastructure.output.adapter.client.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-client", fallbackFactory = ClientFeignClientFallbackFactory.class)
public interface ClientFeignClient {

    @GetMapping("/api/client/{id}")
    Response<ClientDTO> findById(@PathVariable("id") String id);
}