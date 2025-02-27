package com.bank.finance.movement.application.service;

import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.movement.application.input.port.TransactionInputPort;
import com.bank.finance.movement.application.output.port.MovementOutputPort;
import com.bank.finance.movement.domain.exception.InvalidBalanceException;
import com.bank.finance.movement.domain.model.MovementDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.bank.finance.movement.domain.model.MovementType.ADD;
import static com.bank.finance.movement.domain.model.MovementType.SUBTRACT;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionInputPort {
  private final MovementOutputPort outputPort;

  @Override
  public MovementDomain makeMovement(MovementDomain movement) {
    Double lastBalance = outputPort.getLastBalance(movement.getAccount().getId()).getValue();

    if (movement.getType().equals(SUBTRACT) && lastBalance - movement.getValue() < 0) {
      throw new InvalidBalanceException("Balance not available");
    }

    return movement.balance(
        movement.getType().equals(SUBTRACT)
            ? lastBalance - movement.getValue()
            : lastBalance + movement.getValue());
  }

  @Override
  public MovementDomain makeFirstMovement(AccountDomain account) {
    if (account.getOpeningBalance() < 0) {
      throw new InvalidBalanceException();
    }

    return MovementDomain.init()
        .type(ADD)
        .date(LocalDate.now())
        .value(account.getOpeningBalance())
        .balance(account.getOpeningBalance())
        .account(AccountDomain.init().id(account.getId()).build())
        .build();
  }
}
