package com.bank.finance.account.application.service;

import com.bank.finance.account.application.input.port.AccountInputPort;
import com.bank.finance.account.application.output.port.AccountOutputPort;
import com.bank.finance.account.domain.exception.AccountNotFoundException;
import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.movement.application.input.port.MovementInputPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountInputPort {

  private final AccountOutputPort outputPort;

  private final MovementInputPort movementInputPort;

  @Override
  public List<AccountDomain> findAll() {
    return outputPort.findAll();
  }

  @Override
  public AccountDomain findById(Long id) {
    return outputPort.findById(id).orElseThrow(AccountNotFoundException::new);
  }

  @Override
  public AccountDomain save(AccountDomain accountDomain) {
    AccountDomain response = outputPort.save(accountDomain);

    movementInputPort.createFirstMovement(response);

    return response;
  }

  @Override
  public void deleteById(Long id) {
    outputPort.deleteById(id);
  }
}
