package com.bank.finance.account.domain.model;

import com.bank.finance.client.domain.model.ClientDomain;
import com.bank.finance.shared.domain.model.EntityBaseDomain;
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
public class AccountDomain extends EntityBaseDomain {

  private String clientId;
  private AccountType type;
  private Long accountNumber;
  private ClientDomain client;
  private Double openingBalance;

  public AccountDomain setClient(ClientDomain client) {
    this.client = client;
    return this;
  }
}
