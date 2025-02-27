package com.bank.finance.account.infrastructure.output.adapter.persistence.repository;

import com.bank.finance.account.application.output.port.AccountOutputPort;
import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.account.infrastructure.output.adapter.persistence.mapper.MapStructAccountPersistenceMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountOutputPort {

  private final AccountJpaRepository repository;
  private final MapStructAccountPersistenceMapper mapper;

  @Override
  public List<AccountDomain> findAll() {
    return mapper.toDomain(repository.findAll());
  }

  @Override
  public Optional<AccountDomain> findById(Long id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  public AccountDomain save(AccountDomain accountDomain) {
    return mapper.toDomain(repository.save(mapper.toEntity(accountDomain)));
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
