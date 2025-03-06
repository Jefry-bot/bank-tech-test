package com.bank.finance.movement.application.service;


import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.client.application.input.port.ClientInputPort;
import com.bank.finance.movement.application.input.port.MovementInputPort;
import com.bank.finance.movement.application.input.port.TransactionInputPort;
import com.bank.finance.movement.application.output.port.MovementOutputPort;
import com.bank.finance.movement.domain.exception.MovementNotFoundException;
import com.bank.finance.movement.domain.model.MovementDomain;
import com.bank.finance.notification.application.input.port.NotificationInputPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementInputPort {

  private final MovementOutputPort outputPort;
  private final ClientInputPort clientInputPort;
  private final TransactionInputPort transactionInputPort;
  private final NotificationInputPort notificationInputPort;

  @Override
  public List<MovementDomain> findAll() {
    return outputPort.findAll();
  }

  @Override
  public MovementDomain findById(Long id) {
    return outputPort.findById(id).orElseThrow(MovementNotFoundException::new);
  }

  public void createFirstMovement(AccountDomain account) {
    MovementDomain result = outputPort.save(transactionInputPort.makeFirstMovement(account));
    this.notificationInputPort.send(result);
  }

  @Override
  public MovementDomain save(MovementDomain movement) {
    MovementDomain result = outputPort.save(transactionInputPort.makeMovement(movement));
    result.getAccount().setClient(clientInputPort.findById(result.getAccount().getClientId()));

    this.notificationInputPort.send(result);

    return result;
  }

  @Override
  public void deleteById(Long id) {
    outputPort.deleteById(id);
  }
}
