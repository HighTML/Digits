package com.hightml.digits;

import com.hightml.digits.scan.*;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marcel Heemskerk (ra52ba) on 29-11-2017.
 */
public class LineTest {

    @Test
    public void test1() throws FontFormatException {
        String a = "" +
                "    _  _     _  _  _  _  _ \n" +
                "  | _| _||_||_ |_   ||_||_|\n" +
                "  ||_  _|  | _||_|  ||_| _|\n" +
                "    _  _  _  _  _  _     _ \n" +
                "|_||_|| || ||_   |  |  ||_ \n" +
                "  | _||_||_||_|  |  |  | _|\n";

        System.out.println(a);
        Reader reader = new Reader(com.hightml.digits.scan.Font.SIMPLE);

        List<Line> lines = reader.parseString(a);

        assertEquals(123456789, lines.get(0).toInteger());
        assertEquals(490067715, lines.get(1).toInteger());
    }

    @Test
    public void test2() throws FontFormatException, IOException {
        Reader reader = new Reader(com.hightml.digits.scan.Font.SIMPLE);

        List<Line> lines = reader.parseFile(Paths.get("src/test/resources/sample_ok.txt"));

        lines.stream().forEach(l -> System.out.println(l.toInteger()));

        assertEquals(123456789, lines.get(0).toInteger());
        assertEquals(490067715, lines.get(1).toInteger());
    }
}