package com.bank.finance.client.application.input.port;

import com.bank.finance.client.domain.model.ClientDomain;

public interface ClientInputPort {

    ClientDomain findById(Long id);
}
