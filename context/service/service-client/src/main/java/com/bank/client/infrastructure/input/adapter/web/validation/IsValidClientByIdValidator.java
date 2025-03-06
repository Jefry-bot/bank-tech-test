package com.bank.client.infrastructure.input.adapter.web.validation;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.bank.client.application.input.port.ClientInputPort;
import com.bank.client.domain.exception.ClientNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsValidClientByIdValidator implements ConstraintValidator<IsValidClient, String> {

  private final ClientInputPort inputPort;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (isNull(value)) {
      return true;
    }

    try {
      return nonNull(inputPort.findById(value));
    } catch (ClientNotFoundException exception) {
      return false;
    }
  }
}
