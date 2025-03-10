package com.bank.finance.account.infrastructure.output.adapter.persistence.repository;

import com.bank.finance.account.application.output.port.AccountOutputPort;
import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.account.infrastructure.output.adapter.persistence.mapper.MapStructAccountPersistenceMapper;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountOutputPort {

  private final AccountJpaRepository repository;
  private final MapStructAccountPersistenceMapper mapper;

  private static final String CACHE_NAME = "accounts";

  @Override
  @Cacheable(value = CACHE_NAME, key = "'all'")
  public List<AccountDomain> findAll() {
    return mapper.toDomain(repository.findAll());
  }

  @Override
  @Cacheable(value = CACHE_NAME, key = "#id", condition = "#id != null")
  public Optional<AccountDomain> findById(Long id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  @Caching(
      put = {@CachePut(value = CACHE_NAME, key = "#result.id")},
      evict = {@CacheEvict(value = CACHE_NAME, key = "'all'")})
  public AccountDomain save(AccountDomain accountDomain) {
    return mapper.toDomain(repository.save(mapper.toEntity(accountDomain)));
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
