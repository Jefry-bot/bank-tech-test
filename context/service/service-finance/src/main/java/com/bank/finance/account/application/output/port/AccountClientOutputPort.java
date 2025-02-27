package com.bank.finance.account.application.output.port;

import com.bank.finance.client.domain.model.ClientDomain;

public interface AccountClientOutputPort {
  ClientDomain validIfExistClient(Long id);
}
