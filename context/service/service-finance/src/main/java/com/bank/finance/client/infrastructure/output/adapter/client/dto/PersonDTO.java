package com.bank.finance.client.infrastructure.output.adapter.client.dto;

import com.bank.finance.client.domain.model.Gender;
import com.bank.finance.shared.infrastructure.input.adapter.web.dto.EntityBaseDTO;
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
public class PersonDTO extends EntityBaseDTO {

  protected Integer age;
  protected String phone;
  protected Gender gender;
  protected String address;
  @NotNull protected String name;
  protected String identification;
}
