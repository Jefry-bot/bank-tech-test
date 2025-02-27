package com.bank.finance.movement.domain.exception;

import com.bank.common.domain.exceptions.ApplicationRuntimeException;

public class InvalidBalanceException extends ApplicationRuntimeException {

  public InvalidBalanceException() {
    super("The balance is invalid");
  }

  public InvalidBalanceException(String message) {
    super(message);
  }
}
