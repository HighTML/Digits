package com.hightml.digits;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        String a =
                        "    _  _     _  _  _  _  _ \n" +
                        "  | _| _||_||_ |_   ||_||_|\n" +
                        "  ||_  _|  | _||_|  ||_| _|\n" +
                        "    _  _  _  _  _  _     _ \n" +
                        "|_||_|| || ||_   |  |  ||_ \n" +
                        "  | _||_||_||_|  |  |  | _|\n";

        System.out.println(a);
        List<Line> lines = Reader.parseString(a);


        // Digits printen als geparsde characters:
        for (Line line : lines) {
            List<Digit> digits = line.getDigits();
            for (Digit digit : digits) {
                System.out.print(digit.toString());
            }
            System.out.println();
        }


    }
}
