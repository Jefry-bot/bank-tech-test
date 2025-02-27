package com.bank.finance.movement.application.input.port;

import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.movement.domain.model.MovementDomain;
import java.util.List;

public interface MovementInputPort {

  List<MovementDomain> findAll();

  MovementDomain findById(Long id);

  void createFirstMovement(AccountDomain account);

  MovementDomain save(MovementDomain movementDomain);

  void deleteById(Long id);
}
