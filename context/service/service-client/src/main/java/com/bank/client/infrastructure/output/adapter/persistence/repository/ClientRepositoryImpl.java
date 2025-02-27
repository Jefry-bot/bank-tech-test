package com.bank.client.infrastructure.output.adapter.persistence.repository;

import com.bank.client.application.output.port.ClientOutputPort;
import com.bank.client.domain.model.ClientDomain;
import com.bank.client.infrastructure.output.adapter.persistence.mapper.MapStructClientPersistenceMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientOutputPort {

  private final ClientJpaRepository repository;
  private final MapStructClientPersistenceMapper mapper;

  @Override
  public List<ClientDomain> findAll() {
    return mapper.toDomain(repository.findAll());
  }

  @Override
  public Optional<ClientDomain> findById(Long id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  public ClientDomain save(ClientDomain client) {
    return mapper.toDomain(repository.save(mapper.toEntity(client)));
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
