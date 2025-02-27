package com.bank.client.application.output.port;

import com.bank.client.domain.model.ClientDomain;
import java.util.List;
import java.util.Optional;

public interface ClientOutputPort {

  List<ClientDomain> findAll();

  Optional<ClientDomain> findById(Long id);

  ClientDomain save(ClientDomain client);

  void deleteById(Long id);
}
