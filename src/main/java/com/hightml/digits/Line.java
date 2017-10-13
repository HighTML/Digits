package com.hightml.digits;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Line {
    List<Digit> digits = new ArrayList<Digit>();

    public Line(Font font, List<String> rawline) throws FontFormatException {
        List<String[]> digitParts = new ArrayList<>();

        rawline.stream().forEach(r -> digitParts.add(r.split("(?<=\\G.{" + font.getWidth() + "})")));

        int nrDigitsInLine = digitParts.get(0).length;
        for (int xDigitInLine = 0; xDigitInLine < nrDigitsInLine; xDigitInLine++) {
            List<String> digitPixels = new ArrayList<>();
            for (int yPixelRow = 0; yPixelRow < font.getHeight(); yPixelRow++) {
                digitPixels.add(digitParts.get(yPixelRow)[xDigitInLine]);
            }
            digits.add(new Digit(font, digitPixels));
        }
    }

    public String toFontString(final Font font) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < font.getHeight(); y++) {
            for (Digit d : digits) {
                sb.append(font.getFontCharacter(d.getCharacter()).get(y));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
