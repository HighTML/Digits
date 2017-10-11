package com.hightml.digits;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String a =
                        "    _  _     _  _  _  _  _\n" +
                        "  | _| _||_||_ |_   ||_||_|\n" +
                        "  ||_  _|  | _||_|  ||_| _|\n" +
                        "    _  _  _  _  _  _     _ \n" +
                        "|_||_|| || ||_   |  |  ||_ \n" +
                        "  | _||_||_||_|  |  |  | _|";

        List<Line> lines = DigitLinesReader.parseString(a);

        for (Line line:lines) {
            List<Digit> digits = line.getDigits();
            System.out.println(digits.stream().map(Object::toString).collect(Collectors.joining(",")));
        }




    }
}
