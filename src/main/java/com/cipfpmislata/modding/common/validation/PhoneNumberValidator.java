package com.cipfpmislata.modding.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Integer>{

    @Override
    public boolean isValid(Integer phoneNumber, ConstraintValidatorContext context) {
        return (String.valueOf(phoneNumber).length()==9);
    }
}
