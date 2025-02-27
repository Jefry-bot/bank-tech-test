package com.bank.finance.account.infrastructure.input.adapter.web.validation;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.bank.finance.account.application.input.port.AccountInputPort;
import com.bank.finance.account.domain.exception.AccountNotFoundException;
import com.bank.finance.account.infrastructure.input.adapter.web.dto.AccountDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsValidAccountValidator implements ConstraintValidator<IsValidAccount, AccountDTO> {

  private final AccountInputPort inputPort;

  @Override
  public boolean isValid(AccountDTO value, ConstraintValidatorContext context) {
    if (isNull(value) || isNull(value.getId())) {
      return true;
    }

    try {
      return nonNull(inputPort.findById(value.getId()));
    } catch (AccountNotFoundException exception) {
      return false;
    }
  }
}
