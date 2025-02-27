package com.bank.finance.client.infrastructure.output.adapter.client.mapper;

import com.bank.finance.client.domain.model.ClientDomain;
import com.bank.finance.shared.infrastructure.input.adapter.web.dto.ClientDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MapStructClientMapper {

  ClientDomain toDomain(ClientDTO dto);
}
