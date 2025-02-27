package com.bank.finance.account.application.output.port;

import com.bank.finance.account.domain.model.AccountDomain;
import java.util.List;
import java.util.Optional;

public interface AccountOutputPort {

  List<AccountDomain> findAll();

  Optional<AccountDomain> findById(Long id);

  AccountDomain save(AccountDomain accountDomain);

  void deleteById(Long id);
}
