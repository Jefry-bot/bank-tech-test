package com.bank.client.application.input.port;

import com.bank.client.domain.model.ClientDomain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientInputPort {

  Flux<ClientDomain> findAll();

  Mono<ClientDomain> findById(String id);

  Mono<ClientDomain> save(ClientDomain client);

  Mono<Void> deleteById(String id);
}
