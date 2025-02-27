package com.bank.finance.account.infrastructure.output.adapter.persistence.repository;

import com.bank.finance.account.infrastructure.output.adapter.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {}
