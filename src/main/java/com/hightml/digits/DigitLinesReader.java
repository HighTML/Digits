package com.hightml.digits;

import java.util.ArrayList;
import java.util.List;

public class DigitLinesReader {
    public static List<Line> parseString(String a) {
        String[] rawlines = a.split("\n");
        assert (rawlines.length % Digit.HEIGHT == 0);

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i<rawlines.length; i+=3) {
            lines.add(new Line(rawlines[i], rawlines[i+1], rawlines[i+2]));
        }
        return lines;
    }
}
