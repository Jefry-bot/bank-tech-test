package com.bank.client.infrastructure.input.adapter.web.mapper;

import com.bank.client.domain.model.ClientDomain;
import com.bank.client.infrastructure.input.adapter.web.dto.ClientDTO;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MapStructClientWebMapper {

  ClientDTO toDto(ClientDomain domain);

  List<ClientDTO> toDto(List<ClientDomain> domain);

  ClientDomain toDomain(ClientDTO dto);
}
