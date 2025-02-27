package com.bank.finance.account.infrastructure.input.adapter.web.validation;

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
@Constraint(validatedBy = {IsValidAccountByIdValidator.class, IsValidAccountValidator.class})
public @interface IsValidAccount {
  String message() default "Account was not found";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
