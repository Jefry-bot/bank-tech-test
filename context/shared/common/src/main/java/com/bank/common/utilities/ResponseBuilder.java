package com.bank.common.utilities;

import com.bank.common.adapter.input.web.dto.ExceptionBody;
import com.bank.common.adapter.input.web.dto.Response;
import com.bank.common.domain.model.ErrorStatus;
import lombok.NoArgsConstructor;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;


@NoArgsConstructor(access = PRIVATE)
public class ResponseBuilder {

    public static Response<String> success(Runnable response) {
        response.run();

        return Response
                .<String>init()
                    .data(OK.getReasonPhrase())
                    .code(OK.value())
                .build();
    }

    public static <T> Response<T> success(T data) {
        return Response
                .<T>init()
                    .data(data)
                    .code(OK.value())
                .build();
    }

    public static <T> Response<T> failed(T data) {
        return Response
                .<T>init()
                    .data(data)
                    .code(INTERNAL_SERVER_ERROR.value())
                .build();
    }

    public static <T> Response<T> failed(T data, ErrorStatus status) {
        return Response
                .<T>init()
                    .data(data)
                    .code(status.getValue())
                .build();
    }

    public static Response<Object> failed(ExceptionBody exceptionBody, ErrorStatus status) {
        return Response
                .init()
                    .code(status.getValue())
                    .data(ofNullable(exceptionBody.getAdditionalInformation()).orElse(exceptionBody.getMessage()))
                .build();
    }
}