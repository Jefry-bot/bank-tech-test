package com.bank.finance.movement.infrastructure.output.adapter.persistence.mapper;

import com.bank.finance.movement.domain.model.MovementDomain;
import com.bank.finance.movement.infrastructure.output.adapter.persistence.entity.MovementEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMovementPersistenceMapper {

  MovementDomain toDomain(MovementEntity entity);

  List<MovementDomain> toDomain(List<MovementEntity> entities);

  MovementEntity toEntity(MovementDomain domain);
}
