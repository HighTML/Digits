package com.hightml.digits;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String a = "" +
                "    _  _     _  _  _  _  _ \n" +
                "  | _| _||_||_ |_   ||_||_|\n" +
                "  ||_  _|  | _||_|  ||_| _|\n" +
                "    _  _  _  _  _  _     _ \n" +
                "|_||_|| || ||_   |  |  ||_ \n" +
                "  | _||_||_||_|  |  |  | _|\n";

        System.out.println(a);
        Reader reader = new Reader(Font.SIMPLE);
        try {
            List<Line> lines = reader.parseString(a);

            // Digits printen als geparsde characters:
            for (Line line : lines) {
                List<Digit> digits = line.getDigits();
                for (Digit digit : digits) {
                    System.out.print(digit.toString());
                }
                System.out.println();
            }

            // En nu in een one-liner:
            lines.stream().forEach(l -> System.out.println(l.getDigits().stream().map(Digit::toString).collect(Collectors.joining(" "))));


            // Digits printen in een ander font:
            lines.stream().forEach(l -> System.out.println(l.toFontString(Font.BANNER)));


        } catch (FontFormatException e) {
            System.err.println("Could not parse using font " + reader.getFont().getName());
        }


    }
}
