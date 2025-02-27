package com.bank.finance.shared.infrastructure.output.adapter.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({FIELD, PARAMETER})
@Constraint(validatedBy = {IsValidClientByIdValidator.class})
public @interface IsValidClient {
  String message() default "Client was not found";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
