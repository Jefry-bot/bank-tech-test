package com.bank.client.infrastructure.output.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "CLIENT")
public class ClientEntity extends PersonEntity {

  @Column(name = "PASSWORD")
  private String password;

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
