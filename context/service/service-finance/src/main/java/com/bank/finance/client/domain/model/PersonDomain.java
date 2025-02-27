package com.bank.finance.client.domain.model;

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
public class PersonDomain extends EntityBaseDomain {

  protected String name;
  protected Integer age;
  protected String phone;
  protected Gender gender;
  protected String address;
  protected String identification;
}
