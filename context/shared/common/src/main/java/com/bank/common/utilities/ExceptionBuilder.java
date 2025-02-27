package com.bank.common.utilities;

import com.bank.common.adapter.input.web.dto.ExceptionBody;
import lombok.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.exception.ExceptionUtils.getRootCause;

public class ExceptionBuilder {

    private final ExceptionBody exceptionBody;

    public ExceptionBuilder(Throwable throwable) {
        StackTraceElement stackTrace = throwable.getStackTrace()[0];

        this.exceptionBody = ExceptionBody
                .init()
                    .endpoint(getCurrentEndpoint())
                    .message(throwable.getMessage())
                    .clazz(stackTrace.getClassName())
                    .method(stackTrace.getMethodName())
                    .exceptionName(throwable.getClass().getName())
                    .line(String.valueOf(stackTrace.getLineNumber()))
                    .messageDetail(ofNullable(getRootCause(throwable)).orElse(throwable).getMessage())
                    .date(DateTimeFormatter.ofLocalizedDateTime(MEDIUM).format(DateUtility.now("GMT-5")))
                .build();
    }

    public static String getCurrentEndpoint() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getRequestURI();
    }

    public static ExceptionBuilder init(@NonNull Throwable throwable) {
        return new ExceptionBuilder(throwable);
    }

    public ExceptionBody build() {
        return exceptionBody;
    }
}