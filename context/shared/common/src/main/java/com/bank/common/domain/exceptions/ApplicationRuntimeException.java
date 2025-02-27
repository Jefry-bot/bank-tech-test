package com.bank.common.domain.exceptions;

import com.bank.common.domain.model.ErrorStatus;

public class ApplicationRuntimeException extends RuntimeException {

    private final ErrorStatus status;

    public ApplicationRuntimeException(String message) {
        super(message);
        this.status = ErrorStatus.BAD_REQUEST;
    }

    public ApplicationRuntimeException(String message, ErrorStatus status) {
        super(message);
        this.status = status;
    }

    public ApplicationRuntimeException(Throwable cause, ErrorStatus status) {
        super(cause);
        this.status = status;
    }

    public ApplicationRuntimeException(String message, Throwable cause, ErrorStatus status) {
        super(message, cause);
        this.status = status;
    }
    public ErrorStatus status() {
        return status;
    }
}
