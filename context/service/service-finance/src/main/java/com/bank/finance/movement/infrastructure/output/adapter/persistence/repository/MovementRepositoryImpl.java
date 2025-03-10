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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementOutputPort {

  private final MovementJpaRepository repository;
  @PersistenceContext private final EntityManager manager;
  private final MapStructMovementPersistenceMapper mapper;

  private static final String CACHE_NAME = "movements";

  @Override
  public LastMovementDomain getLastBalance(Long account) {
    return repository.getLastBalance(account);
  }

  @Override
  @Cacheable(value = CACHE_NAME, key = "'all'")
  public List<MovementDomain> findAll() {
    return mapper.toDomain(repository.findAll());
  }

  @Override
  @Cacheable(value = CACHE_NAME, key = "#id")
  public Optional<MovementDomain> findById(Long id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  @Caching(
      put = {@CachePut(value = CACHE_NAME, key = "#result.id")},
      evict = {
        @CacheEvict(value = CACHE_NAME, key = "'all'")
      })
  public MovementDomain save(MovementDomain movementDomain) {
    return mapper.toDomain(manager.merge(mapper.toEntity(movementDomain)));
  }

  @Override
  @Caching(
      evict = {
        @CacheEvict(value = CACHE_NAME, key = "#id"),
        @CacheEvict(value = CACHE_NAME, key = "'all'")
      })
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
