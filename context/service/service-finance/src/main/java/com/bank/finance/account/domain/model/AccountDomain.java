package com.bank.finance.account.domain.model;

import com.bank.finance.client.domain.model.ClientDomain;
import com.bank.finance.shared.domain.model.EntityBaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "init")
public class AccountDomain extends EntityBaseDomain implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long clientId;
  private AccountType type;
  private Long accountNumber;
  private ClientDomain client;
  private Double openingBalance;

  public AccountDomain setClient(ClientDomain client) {
    this.client = client;
    return this;
  }
}
