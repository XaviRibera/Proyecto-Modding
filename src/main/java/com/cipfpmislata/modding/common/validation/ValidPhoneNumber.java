package com.cipfpmislata.modding.common.validation;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface ValidPhoneNumber {
    String message() default "El numero de telefono necesita 9 digitos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
