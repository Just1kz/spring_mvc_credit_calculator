package com.antonbelykh.spring.spring_mvc.validation.annotation;


import com.antonbelykh.spring.spring_mvc.validation.validator.CheckPeriodValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPeriodValidator.class)
public @interface CheckPeriod {

    public double value() default 5;

    public String message() default "Period of credit should be min 6 month, pls try again";

    public Class<?> [] groups() default {};

    public Class<? extends Payload> [] payload() default {};
}
