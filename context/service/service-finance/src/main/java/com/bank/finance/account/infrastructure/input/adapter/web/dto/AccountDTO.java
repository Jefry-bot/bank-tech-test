package com.bank.finance.account.infrastructure.input.adapter.web.dto;

import com.bank.finance.account.domain.model.AccountType;
import com.bank.finance.shared.infrastructure.input.adapter.web.dto.EntityBaseDTO;
import com.bank.finance.shared.infrastructure.output.adapter.validation.IsValidClient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "init")
public class AccountDTO extends EntityBaseDTO {

  private Long id;
  @NotNull @IsValidClient private Long clientId;
  @NotNull private AccountType type;
  @NotNull private Long accountNumber;
  @NotNull private Double openingBalance;
}
