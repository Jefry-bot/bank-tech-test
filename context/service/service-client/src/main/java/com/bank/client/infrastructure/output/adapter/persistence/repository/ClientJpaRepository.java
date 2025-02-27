package com.bank.client.infrastructure.output.adapter.persistence.repository;

import com.bank.client.infrastructure.output.adapter.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {}
