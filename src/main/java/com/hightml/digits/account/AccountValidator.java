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
        char[] chars = String.valueOf(account.getNumber()).toCharArray();
        int sum = 0;
        for(int i = 1; i <= chars.length; i++) {
            int value = Character.digit(chars[chars.length-i], 10);
            sum += value * i;
        }
        return (sum % 11) == 0;
    }

}
