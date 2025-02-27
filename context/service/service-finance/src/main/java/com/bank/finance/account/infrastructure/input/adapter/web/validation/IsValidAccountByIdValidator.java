package com.bank.finance.account.infrastructure.input.adapter.web.validation;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.bank.finance.account.application.input.port.AccountInputPort;
import com.bank.finance.account.domain.exception.AccountNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsValidAccountByIdValidator implements ConstraintValidator<IsValidAccount, Long> {

  private final AccountInputPort inputPort;

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (isNull(value)) {
      return true;
    }

    try {
      return nonNull(inputPort.findById(value));
    } catch (AccountNotFoundException exception) {
      return false;
    }
  }
}
