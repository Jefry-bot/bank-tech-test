package com.bank.finance.movement.domain.model;

import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.shared.domain.model.EntityBaseDomain;
import java.time.LocalDate;
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
public class MovementDomain extends EntityBaseDomain {

  private Double value;
  private Double balance;
  protected LocalDate date;
  private MovementType type;
  private AccountDomain account;

  public MovementDomain balance(Double balance) {
    this.balance = balance;
    return this;
  }
}
