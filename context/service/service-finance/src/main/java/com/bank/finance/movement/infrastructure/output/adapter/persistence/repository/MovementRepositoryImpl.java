package com.bank.finance.movement.infrastructure.output.adapter.persistence.repository;

import com.bank.finance.movement.application.output.port.MovementOutputPort;
import com.bank.finance.movement.domain.model.LastMovementDomain;
import com.bank.finance.movement.domain.model.MovementDomain;
import com.bank.finance.movement.infrastructure.output.adapter.persistence.mapper.MapStructMovementPersistenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementOutputPort {

  private final MovementJpaRepository repository;
  @PersistenceContext private final EntityManager manager;
  private final MapStructMovementPersistenceMapper mapper;

  @Override
  public LastMovementDomain getLastBalance(Long account) {
    return repository.getLastBalance(account);
  }

  @Override
  public List<MovementDomain> findAll() {
    return mapper.toDomain(repository.findAll());
  }

  @Override
  public Optional<MovementDomain> findById(Long id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public MovementDomain save(MovementDomain movementDomain) {
    return mapper.toDomain(manager.merge(mapper.toEntity(movementDomain)));
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
