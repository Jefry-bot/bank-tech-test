package com.bank.client.application.service;

import com.bank.client.application.input.port.ClientInputPort;
import com.bank.client.application.output.port.ClientOutputPort;
import com.bank.client.domain.exception.ClientNotFoundException;
import com.bank.client.domain.model.ClientDomain;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientInputPort {

  private final ClientOutputPort outputPort;

  @Override
  public Flux<ClientDomain> findAll() {
    return outputPort.findAll();
  }

  @Override
  public Mono<ClientDomain> findById(String id) {
    return outputPort.findById(id).switchIfEmpty(Mono.error(ClientNotFoundException::new));
  }

  @Override
  public Mono<ClientDomain> save(ClientDomain client) {
    return outputPort.save(client);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return outputPort.deleteById(id);
  }
}
