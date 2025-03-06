package com.bank.client.infrastructure.output.adapter.persistence.repository;

import com.bank.client.infrastructure.output.adapter.persistence.entity.ClientDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientReactiveRepository extends ReactiveMongoRepository<ClientDocument, String> {}
