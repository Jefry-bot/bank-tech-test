package com.bank.finance.account.infrastructure.output.adapter.persistence.entity;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.EnumType.STRING;

import com.bank.finance.account.domain.model.AccountType;
import com.bank.finance.movement.infrastructure.output.adapter.persistence.entity.MovementEntity;
import com.bank.finance.shared.infrastructure.output.adapter.persistence.entity.EntityBase;
import jakarta.persistence.*;
import java.util.List;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity extends EntityBase {

  @Column(name = "ACCOUNT_NUMBER")
  private Long accountNumber;

  @Column(name = "ACCOUNT_TYPE")
  @Enumerated(STRING)
  private AccountType type;

  @Column(name = "OPENING_BALANCE")
  private Double openingBalance;

  @Column(name = "CLIENT_ID")
  private Long clientId;

  @OneToMany(mappedBy = "account", cascade = REMOVE)
  List<MovementEntity> movements;

  @Override
  @Generated
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  @Generated
  public int hashCode() {
    return super.hashCode();
  }
}
