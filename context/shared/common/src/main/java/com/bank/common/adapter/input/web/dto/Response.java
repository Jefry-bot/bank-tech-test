package com.bank.common.adapter.input.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderMethodName = "init")
public class Response<T> {

    private T data;
    private Integer code;
}
