package com.bank.client.infrastructure.output.adapter.persistence.mapper;

import com.bank.client.domain.model.ClientDomain;
import com.bank.client.infrastructure.output.adapter.persistence.entity.ClientEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructClientPersistenceMapper {

  ClientDomain toDomain(ClientEntity client);

  List<ClientDomain> toDomain(List<ClientEntity> clients);

  ClientEntity toEntity(ClientDomain client);
}
