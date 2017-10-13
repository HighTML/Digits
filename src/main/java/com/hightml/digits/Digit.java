package com.hightml.digits;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Digit {
    public static final int HEIGHT = 3;
    public static final int WIDTH = HEIGHT;

    String line1;
    String line2;
    String line3;


    public int toInteger() {
        if (
                line1.equals("   ") &&
                        line2.equals("  |") &&
                        line3.equals("  |")) {
            return 1;
        }

        if (
                line1.equals(" _ ") &&
                        line2.equals(" _|") &&
                        line3.equals("|_ ")) {
            return 2;
        }

        if (
                line1.equals(" _ ") &&
                        line2.equals(" _|") &&
                        line3.equals(" _|")) {
            return 3;
        }

        if (
                line1.equals("   ") &&
                        line2.equals("|_|") &&
                        line3.equals("  |")) {
            return 4;
        }

        if (
                line1.equals(" _ ") &&
                        line2.equals("|_ ") &&
                        line3.equals(" _|")) {
            return 5;
        }

        if (
                line1.equals(" _ ") &&
                        line2.equals("|_ ") &&
                        line3.equals("|_|")) {
            return 6;
        }

        if (
                line1.equals(" _ ") &&
                        line2.equals("  |") &&
                        line3.equals("  |")) {
            return 7;
        }

        if (
                line1.equals(" _ ") &&
                        line2.equals("|_|") &&
                        line3.equals("|_|")) {
            return 8;
        }

        if (
                line1.equals(" _ ") &&
                        line2.equals("|_|") &&
                        line3.equals(" _|")) {
            return 9;
        }

        return 0;
    }

    public String toString() {
        return String.valueOf(toInteger());
    }
}
