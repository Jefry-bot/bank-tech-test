package com.bank.client.infrastructure.output.adapter.persistence.mapper;

import com.bank.client.domain.model.ClientDomain;
import com.bank.client.infrastructure.output.adapter.persistence.entity.ClientDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructClientPersistenceMapper {

  ClientDomain toDomain(ClientDocument client);

  ClientDocument toCollection(ClientDomain client);
}
