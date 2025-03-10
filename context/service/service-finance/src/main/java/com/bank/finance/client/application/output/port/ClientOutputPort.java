package com.bank.finance.client.application.output.port;

import com.bank.finance.client.domain.model.ClientDomain;

import java.util.Optional;

public interface ClientOutputPort {

    Optional<ClientDomain> findById(String id);
}
