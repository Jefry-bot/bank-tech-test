package com.bank.finance.account.infrastructure.input.adapter.web.mapper;

import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.account.infrastructure.input.adapter.web.dto.AccountDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructAccountWebMapper {

  AccountDTO toDto(AccountDomain domain);

  List<AccountDTO> toDto(List<AccountDomain> domains);

  AccountDomain toDomain(AccountDTO dto);
}
