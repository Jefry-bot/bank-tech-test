package com.bank.finance.movement.application.output.port;

import com.bank.finance.movement.domain.model.LastMovementDomain;
import com.bank.finance.movement.domain.model.MovementDomain;
import java.util.List;
import java.util.Optional;

public interface MovementOutputPort {

  List<MovementDomain> findAll();

  Optional<MovementDomain> findById(Long id);

  LastMovementDomain getLastBalance(Long account);

  MovementDomain save(MovementDomain movementDomain);

  void deleteById(Long id);
}
