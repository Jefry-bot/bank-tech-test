package com.bank.finance.client.infrastructure.output.adapter.client.feign;

import com.bank.finance.client.application.output.port.ClientOutputPort;
import com.bank.finance.client.domain.model.ClientDomain;
import com.bank.finance.client.infrastructure.output.adapter.client.mapper.MapStructClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FeignClientAdapterImpl implements ClientOutputPort {

  private final ClientFeignClient client;
  private final MapStructClientMapper mapper;

  @Override
  public Optional<ClientDomain> findById(String id) {
    return Optional.of(client.findById(id).getData()).map(mapper::toDomain);
  }
}
