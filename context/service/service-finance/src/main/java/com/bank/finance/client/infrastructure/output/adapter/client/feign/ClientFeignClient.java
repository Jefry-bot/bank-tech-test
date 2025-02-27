package com.bank.finance.client.infrastructure.output.adapter.client.feign;

import com.bank.finance.shared.infrastructure.input.adapter.web.dto.ClientDTO;
import com.bank.common.adapter.input.web.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-client", url = "http://localhost:8081", fallbackFactory = ClientFeignClientFallbackFactory.class)
public interface ClientFeignClient {

    @GetMapping("/api/client/{id}")
    Response<ClientDTO> findById(@PathVariable("id") Long id);
}