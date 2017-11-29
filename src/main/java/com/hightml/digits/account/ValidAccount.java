package com.hightml.digits.account;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Marcel Heemskerk (m07g363) on 3-4-2017.
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AccountValidator.class)
@Documented
public @interface ValidAccount {

    String message() default "Account checksum is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
