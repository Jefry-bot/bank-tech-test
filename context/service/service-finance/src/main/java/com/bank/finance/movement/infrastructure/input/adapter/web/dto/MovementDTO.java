package com.bank.finance.movement.infrastructure.input.adapter.web.dto;

import com.bank.finance.account.infrastructure.input.adapter.web.dto.AccountDTO;
import com.bank.finance.account.infrastructure.input.adapter.web.validation.IsValidAccount;
import com.bank.finance.movement.domain.model.MovementType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class MovementDTO {

  @NotNull private Double value;
  private Double balance;
  @NotNull private MovementType type;
  @NotNull @IsValidAccount private AccountDTO account;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  protected LocalDate date;
}
