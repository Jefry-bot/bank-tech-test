package com.bank.finance.account.domain.exception;

import com.bank.common.domain.exceptions.NotFoundException;

public class ClientNotFoundException extends NotFoundException {

    public ClientNotFoundException() {
        super("Client was not found");
    }
}
