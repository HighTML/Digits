package com.hightml.digits.account;

/**
 * Created by Marcel Heemskerk (ra52ba) on 29-11-2017.
 */
@ValidAccount
public class Account {
    private long number;

    public Account(long number) {
        this.number = number;
    }

    public String toString() {
        return String.valueOf(number);
    }

    public long getNumber() {
        return number;
    }

}
