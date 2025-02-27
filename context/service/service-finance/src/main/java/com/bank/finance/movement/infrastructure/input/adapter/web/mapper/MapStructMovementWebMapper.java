package com.bank.finance.movement.infrastructure.input.adapter.web.mapper;

import com.bank.finance.movement.domain.model.MovementDomain;
import com.bank.finance.movement.infrastructure.input.adapter.web.dto.MovementDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMovementWebMapper {

  MovementDTO toDto(MovementDomain domain);

  List<MovementDTO> toDto(List<MovementDomain> domain);

  MovementDomain toDomain(MovementDTO dto);
}
