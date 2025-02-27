package com.bank.common.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus {

    NOT_FOUND(404, "Was not found"),
    BAD_REQUEST(400, "Bad Request");

    private final Integer value;
    private final String message;
}
