package com.bank.finance.movement.domain.exception;

import com.bank.common.domain.exceptions.NotFoundException;

public class MovementNotFoundException extends NotFoundException {

    public MovementNotFoundException() {
        super("Movement wat not found.");
    }
}
