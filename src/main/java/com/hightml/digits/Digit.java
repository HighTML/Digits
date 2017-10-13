package com.hightml.digits;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Digit {

    private Font font;
    private Character character;

    public Digit(Font font, List<String> digitPixels) throws FontFormatException {
        this.font = font;
        character = font.match(digitPixels);
        if (character == null) throw new FontFormatException("Could not match to font " + font.getName());
    }

    public String toString() {
        return String.valueOf(character);
    }

    public int toInteger() {
        return Integer.valueOf(character);
    }

    public String toFontString() {
        return toFontString(font);
    }

    public String toFontString(Font font) {
        return font.getFontCharacter(character).stream().collect(Collectors.joining("\n"));
    }


}
