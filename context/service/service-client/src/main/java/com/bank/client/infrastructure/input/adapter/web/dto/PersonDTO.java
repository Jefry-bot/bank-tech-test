package com.bank.client.infrastructure.input.adapter.web.dto;


import com.bank.client.domain.model.Gender;
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
public class PersonDTO extends DocumentBaseDTO {
  protected Integer age;
  protected String phone;
  protected Gender gender;
  protected String address;
  @NotNull protected String name;
  protected String identification;
}
