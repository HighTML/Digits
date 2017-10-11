package com.hightml.digits;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Digit {
    public static final int HEIGHT = 3;
    public static final int WIDTH = 3;

    String line1;
    String line2;
    String line3;

    public int toInteger() {
        if (
                line1 == "   " &&
                        line2 == "  |" &&
                        line3 == "  |") {
            return 1;
        }

        if (
                line1 == " _ " &&
                        line2 == " _|" &&
                        line3 == "|_ ") {
            return 2;
        }

        if (
                line1 == " _ " &&
                        line2 == " _|" &&
                        line3 == " _|") {
            return 3;
        }

        if (
                line1 == "   " &&
                        line2 == "|_|" &&
                        line3 == "  |") {
            return 4;
        }

        if (
                line1 == " _ " &&
                        line2 == "|_ " &&
                        line3 == " _|") {
            return 5;
        }

        if (
                line1 == " _ " &&
                        line2 == "|_ " &&
                        line3 == "|_|") {
            return 6;
        }

        if (
                line1 == " _ " &&
                        line2 == "  |" &&
                        line3 == "  |") {
            return 7;
        }

        if (
                line1 == " _ " &&
                        line2 == "|_|" &&
                        line3 == "|_|") {
            return 8;
        }

        if (
                line1 == " _ " &&
                        line2 == "|_|" &&
                        line3 == " _|") {
            return 9;
        }

        return 0;
    }

    public String toString() {
        return String.valueOf(toInteger());
    }
}
