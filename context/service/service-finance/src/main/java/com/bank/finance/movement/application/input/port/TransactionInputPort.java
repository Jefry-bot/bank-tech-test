package com.bank.finance.movement.application.input.port;

import com.bank.finance.account.domain.model.AccountDomain;
import com.bank.finance.movement.domain.model.MovementDomain;

public interface TransactionInputPort {
    MovementDomain makeMovement(MovementDomain movementDomain);
    MovementDomain makeFirstMovement(AccountDomain accountDomain);
}
