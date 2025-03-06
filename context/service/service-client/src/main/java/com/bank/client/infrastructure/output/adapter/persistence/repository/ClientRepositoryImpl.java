package com.bank.client.infrastructure.output.adapter.persistence.repository;

import com.bank.client.application.output.port.ClientOutputPort;
import com.bank.client.domain.model.ClientDomain;
import com.bank.client.infrastructure.output.adapter.persistence.mapper.MapStructClientPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientOutputPort {

  private final ClientReactiveRepository repository;
  private final MapStructClientPersistenceMapper mapper;

  @Override
  public Flux<ClientDomain> findAll() {
    return repository.findAll().map(mapper::toDomain);
  }

  @Override
  public Mono<ClientDomain> findById(String id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  public Mono<ClientDomain> save(ClientDomain client) {
    return repository.save(mapper.toCollection(client)).map(mapper::toDomain);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return repository.deleteById(id);
  }
}
