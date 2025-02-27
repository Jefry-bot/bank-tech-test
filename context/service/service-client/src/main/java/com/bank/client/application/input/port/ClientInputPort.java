package com.bank.client.application.input.port;

import com.bank.client.domain.model.ClientDomain;
import java.util.List;

public interface ClientInputPort {

  List<ClientDomain> findAll();

  ClientDomain findById(Long id);

  ClientDomain save(ClientDomain client);

  void deleteById(Long id);
}
