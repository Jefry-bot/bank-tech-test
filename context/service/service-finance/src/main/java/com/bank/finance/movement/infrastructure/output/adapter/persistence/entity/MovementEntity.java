package com.bank.finance.movement.infrastructure.output.adapter.persistence.entity;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;

import com.bank.finance.account.infrastructure.output.adapter.persistence.entity.AccountEntity;
import com.bank.finance.movement.domain.model.MovementType;
import com.bank.finance.shared.infrastructure.output.adapter.persistence.entity.EntityBase;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Entity
@Table(name = "MOVEMENT")
public class MovementEntity extends EntityBase {

  @Column(name = "MOVEMENT_TYPE")
  @Enumerated(STRING)
  private MovementType type;

  @Column(name = "BALANCE")
  private Double balance;

  @Column(name = "VALUE")
  private Double value;

  @Column(name = "DATE")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  protected LocalDate date;

  @JoinColumn(name = "ID_ACCOUNT", referencedColumnName = "ID")
  @ManyToOne(cascade = PERSIST)
  private AccountEntity account;

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
