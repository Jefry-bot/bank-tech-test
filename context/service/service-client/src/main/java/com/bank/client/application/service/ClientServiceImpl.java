package com.bank.client.application.service;

import com.bank.client.application.input.port.ClientInputPort;
import com.bank.client.application.output.port.ClientOutputPort;
import com.bank.client.domain.exception.ClientNotFoundException;
import com.bank.client.domain.model.ClientDomain;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientInputPort {

  private final ClientOutputPort outputPort;

  @Override
  public List<ClientDomain> findAll() {
    return outputPort.findAll();
  }

  @Override
  public ClientDomain findById(Long id) {
    return outputPort.findById(id).orElseThrow(ClientNotFoundException::new);
  }

  @Override
  public ClientDomain save(ClientDomain client) {
    return outputPort.save(client);
  }

  @Override
  public void deleteById(Long id) {
    outputPort.deleteById(id);
  }
}
