package com.bank.client.infrastructure.output.adapter.persistence.entity;

import static jakarta.persistence.EnumType.STRING;

import com.bank.client.domain.model.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class PersonEntity extends EntityBase {

  @Column(name = "NAME")
  protected String name;

  @Column(name = "GENDER")
  @Enumerated(STRING)
  protected Gender gender;

  @Column(name = "AGE")
  protected Integer age;

  @Column(name = "IDENTIFICATION")
  protected String identification;

  @Column(name = "ADDRESS")
  protected String address;

  @Column(name = "PHONE")
  protected String phone;

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
