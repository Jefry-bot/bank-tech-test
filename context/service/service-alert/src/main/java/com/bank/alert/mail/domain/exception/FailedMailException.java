package com.bank.alert.mail.domain.exception;

import com.bank.common.domain.exceptions.ApplicationRuntimeException;

public class FailedMailException extends ApplicationRuntimeException {
    public FailedMailException() {
        super("Current error to send mail.");
    }
}
