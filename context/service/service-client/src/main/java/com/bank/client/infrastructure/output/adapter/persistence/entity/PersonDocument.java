package com.bank.client.infrastructure.output.adapter.persistence.entity;


import com.bank.client.domain.model.Gender;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDocument extends DocumentBase {

  protected String name;

  protected Gender gender;
  
  protected Integer age;
  
  protected String identification;
  
  protected String address;
  
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
