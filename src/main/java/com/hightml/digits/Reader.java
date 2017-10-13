package com.hightml.digits;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Reader {
    private Font font;

    public List<Line> parseString(String a) throws FontFormatException {
        String[] rawlines = a.split("\n");
        assert (rawlines.length % font.getHeight() == 0);

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i<rawlines.length; i+=font.getHeight()) {
            List<String> lineStrings = new ArrayList<>();
            for (int j=0; j<font.getHeight(); j++) lineStrings.add(rawlines[i+j]);
            lines.add(new Line(font, lineStrings));
        }
        return lines;
    }
}
