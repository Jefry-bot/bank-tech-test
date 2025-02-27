package com.bank.finance.account.infrastructure.output.adapter.persistence.mapper;

import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.account.infrastructure.output.adapter.persistence.entity.AccountEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructAccountPersistenceMapper {

  AccountDomain toDomain(AccountEntity entity);

  List<AccountDomain> toDomain(List<AccountEntity> entities);

  AccountEntity toEntity(AccountDomain domain);
}
