package com.antonbelykh.spring.spring_mvc.validation.validator;

import com.antonbelykh.spring.spring_mvc.validation.annotation.CheckPeriod;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPeriodValidator implements ConstraintValidator<CheckPeriod, Double> {

    public Double period;

    @Override
    public void initialize(CheckPeriod constraintAnnotation) {
        period = constraintAnnotation.value();
    }

    //место проверки
    @Override
    public boolean isValid(Double enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue > 5;
    }
}
