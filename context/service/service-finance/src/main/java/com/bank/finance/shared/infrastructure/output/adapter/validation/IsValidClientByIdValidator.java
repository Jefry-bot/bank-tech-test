package com.bank.finance.shared.infrastructure.output.adapter.validation;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.bank.finance.account.application.output.port.AccountClientOutputPort;
import com.bank.finance.account.domain.exception.ClientNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsValidClientByIdValidator implements ConstraintValidator<IsValidClient, Long> {
  private final AccountClientOutputPort outputPort;

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (isNull(value)) {
      return true;
    }

    try {
      return nonNull(outputPort.validIfExistClient(value));
    } catch (ClientNotFoundException exception) {
      return false;
    }
  }
}
