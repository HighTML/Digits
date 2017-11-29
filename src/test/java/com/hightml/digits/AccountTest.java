package com.hightml.digits;

import com.hightml.digits.account.Account;
import com.hightml.digits.account.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.*;

import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Marcel Heemskerk (ra52ba) on 29-11-2017.
 */
@Slf4j
public class AccountTest {

    @Test
    public void test1() {
        Account a = new Account(736160221);
        assertTrue(AccountValidator.isValidAccount(a));

        Account b = new Account(736160222);
        assertFalse(AccountValidator.isValidAccount(b));
    }


    @Valid
    Account goodAccount = new Account(736160221);



    @Valid
    Account badAccount = new Account(736160222);









    @Test
    public void testValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Account>> violations = validator.validate(goodAccount);
        assertTrue(violations.isEmpty());

        violations = validator.validate(badAccount);
        assertFalse(violations.isEmpty());
        assertEquals(violations.iterator().next().getMessage(), "Account checksum is invalid");
        log.debug("Violations {}", violations);

    }



}
