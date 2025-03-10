package com.bank.finance.account.infrastructure.output.adapter.persistence.client;

import com.bank.finance.account.application.output.port.AccountClientOutputPort;
import com.bank.finance.client.application.input.port.ClientInputPort;
import com.bank.finance.client.domain.model.ClientDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountFeignClientImpl implements AccountClientOutputPort {
  private final ClientInputPort inputPort;

  @Override
  public ClientDomain validIfExistClient(String id) {
    return inputPort.findById(id);
  }
}
