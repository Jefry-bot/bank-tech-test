package com.bank.finance.account.domain.exception;

import com.bank.common.domain.exceptions.NotFoundException;

public class AccountNotFoundException extends NotFoundException {

    public AccountNotFoundException() {
        super("Account was not found.");
    }
}
