package com.hightml.digits.account;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Marcel Heemskerk (ra52ba) on 29-11-2017.
 */
public class AccountValidator implements ConstraintValidator<ValidAccount, Account> {

    @Override
    public void initialize(ValidAccount constraintAnnotation) {
    }


    @Override
    public boolean isValid(Account value, ConstraintValidatorContext context) {
        return isValidAccount(value);
    }

    /**
     * For re-use this method is public accessible.
     *
     * @param account
     * @return
     */
    public static boolean isValidAccount(Account account) {
        if (account == null) {
            return false;
        }
        long number = account.getNumber();
        long sum = number % 10;

        for (int multiplier = 2; number > 0; multiplier++) {
            long val = (number /= 10) % 10;
            sum += multiplier * val;
        }
        return sum != 0 && sum % 11 == 0;
    }

}
