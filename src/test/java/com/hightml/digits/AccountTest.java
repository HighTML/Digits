package com.hightml.digits;

import com.hightml.digits.account.Account;
import com.hightml.digits.account.AccountValidator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by Marcel Heemskerk (ra52ba) on 29-11-2017.
 */
public class AccountTest {

    @Test
    public void test1() {
        Account a = new Account(736160221);
        assertTrue(AccountValidator.isValidAccount(a));

        Account b = new Account(736160222);
        assertFalse(AccountValidator.isValidAccount(b));
    }
}
