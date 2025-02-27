package com.bank.common.domain.exceptions;

import com.bank.common.domain.model.ErrorStatus;

public class NotFoundException extends ApplicationRuntimeException {

    public NotFoundException(String message) {
        super(message, ErrorStatus.NOT_FOUND);
    }

    public NotFoundException(Throwable cause) {
        super(cause, ErrorStatus.NOT_FOUND);
    }
}
