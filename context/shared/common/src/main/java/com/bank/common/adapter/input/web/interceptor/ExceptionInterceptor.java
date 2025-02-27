package com.bank.common.adapter.input.web.interceptor;

import com.bank.common.adapter.input.web.dto.ExceptionBody;
import com.bank.common.adapter.input.web.dto.Response;
import com.bank.common.domain.exceptions.ApplicationRuntimeException;
import com.bank.common.domain.exceptions.NotFoundException;
import com.bank.common.domain.model.ErrorStatus;
import com.bank.common.utilities.ExceptionBuilder;
import com.bank.common.utilities.ResponseBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.Map;
import java.util.stream.Collectors;

import static com.bank.common.utilities.ResponseBuilder.failed;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {

    public static final String MESSAGE = "An error has occurred in the server. {}";

    @ResponseStatus
    @ExceptionHandler(Exception.class)
    public Response<String> exception(Exception exception) {
        log.error(MESSAGE, ExceptionBuilder.init(exception).build());

        return ResponseBuilder.failed(MESSAGE);
    }

    @ResponseStatus(OK)
    @ExceptionHandler(ApplicationRuntimeException.class)
    public Response<Object> applicationRuntimeException(ApplicationRuntimeException exception) {
        ExceptionBody exceptionBody = ExceptionBuilder.init(exception).build();

        log.error(MESSAGE, exceptionBody);
        return ResponseBuilder.failed(exceptionBody, exception.status());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Object> whitelistException(MethodArgumentNotValidException exception) {
        ExceptionBody exceptionBody = ExceptionBuilder.init(exception).build();

        exceptionBody.setAdditionalInformation(
            exception.getBindingResult().getAllErrors()
                .stream()
                    .map(FieldError.class::cast)
                        .collect(Collectors.groupingBy(FieldError::getField))
                        .entrySet()
                            .stream().collect(
                                Collectors.toMap(
                                    Map.Entry::getKey,
                                    value -> value
                                        .getValue()
                                            .stream()
                                                .map(
                                                    fieldError -> ofNullable(fieldError.getDefaultMessage()).orElse(EMPTY)
                                                )
                                                    .toList()
                                )
                            )
        );

        log.error(MESSAGE, exceptionBody);
        return ResponseBuilder.failed(exceptionBody, ErrorStatus.BAD_REQUEST);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Response<Object> constraintViolation(ConstraintViolationException exception) {
        ExceptionBody exceptionBody = ExceptionBuilder.init(exception).build();

        exceptionBody.setAdditionalInformation(
            exception.getConstraintViolations()
                .stream()
                        .collect(Collectors.groupingBy(ConstraintViolation::getPropertyPath))
                        .entrySet()
                            .stream().collect(
                                Collectors.toMap(
                                    Map.Entry::getKey,
                                        value -> value
                                            .getValue()
                                                .stream()
                                                    .map(
                                                        fieldError -> ofNullable(fieldError.getMessage()).orElse(EMPTY)
                                                    )
                                                        .toList()
                                )
                        )
        );

        log.error(MESSAGE, exceptionBody);
        return ResponseBuilder.failed(exceptionBody, ErrorStatus.BAD_REQUEST);
    }



    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Response<Object> notFoundException(NotFoundException exception) {
        ExceptionBody exceptionBody = ExceptionBuilder.init(exception).build();

        log.error(MESSAGE, exceptionBody);
        return ResponseBuilder.failed(exceptionBody, exception.status());
    }
}
