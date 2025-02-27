package com.bank.finance.account.application.input.port;

import com.bank.finance.account.domain.model.AccountDomain;
import java.util.List;

public interface AccountInputPort {

  List<AccountDomain> findAll();

  AccountDomain findById(Long id);

  AccountDomain save(AccountDomain accountDomain);

  void deleteById(Long id);
}
