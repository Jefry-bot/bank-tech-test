package com.bank.finance.client.application.service;

import com.bank.finance.client.application.input.port.ClientInputPort;
import com.bank.finance.client.application.output.port.ClientOutputPort;
import com.bank.finance.client.domain.exception.ClientNotFoundException;
import com.bank.finance.client.domain.model.ClientDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientInputPort {

  private final ClientOutputPort outputPort;

  @Override
  public ClientDomain findById(String id) {
    return outputPort.findById(id).orElseThrow(ClientNotFoundException::new);
  }
}
