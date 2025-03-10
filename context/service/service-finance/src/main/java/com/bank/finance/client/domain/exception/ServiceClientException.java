package com.bank.finance.client.domain.exception;

import com.bank.common.domain.exceptions.ApplicationRuntimeException;

public class ServiceClientException extends ApplicationRuntimeException {
    public ServiceClientException() {
        super("Service unavailable");
    }
}
