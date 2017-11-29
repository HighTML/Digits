package com.hightml.digits.scan;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * Created by Marcel Heemskerk on 12-10-2017.
 */
@Data
@AllArgsConstructor
public class Font {
    private int width;
    private int height;
    private String name;
    private Map<Character, List<String>> charMap;

    public static Font SIMPLE;
    public static Font BANNER;

    public Character match(List<String> digitPixels) {
        for (Map.Entry<Character, List<String>> entry : charMap.entrySet()) {
            if (entry.getValue().equals(digitPixels)) return entry.getKey();
        }
        return null;
    }

    public List<String> getFontCharacter(Character c) {
        return charMap.get(c);
    }

    static {
        Map<Character, List<String>> m = new HashMap<>();

        m.put('0', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        "| |",
                        "|_|"
                )));


        m.put('1', new ArrayList<String>(
                Arrays.asList(
                        "   ",
                        "  |",
                        "  |"
                )));


        m.put('2', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        " _|",
                        "|_ "
                )));


        m.put('3', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        " _|",
                        " _|"
                )));

        m.put('4', new ArrayList<String>(
                Arrays.asList(
                        "   ",
                        "|_|",
                        "  |"
                )));

        m.put('5', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        "|_ ",
                        " _|"
                )));

        m.put('6', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        "|_ ",
                        "|_|"
                )));

        m.put('7', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        "  |",
                        "  |"
                )));


        m.put('8', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        "|_|",
                        "|_|"
                )));

        m.put('9', new ArrayList<String>(
                Arrays.asList(
                        " _ ",
                        "|_|",
                        " _|"
                )));


        SIMPLE = new Font(3, 3, "SIMPLE", Collections.unmodifiableMap(m));

        m = new HashMap<>();

        m.put('0', new ArrayList<String>(
                Arrays.asList(
                        "   ###  ",
                        "  #   # ",
                        " #     #",
                        " #     #",
                        " #     #",
                        "  #   # ",
                        "   ###  "
                )));


        m.put('1', new ArrayList<String>(
                Arrays.asList(
                        "     #  ",
                        "    ##  ",
                        "   # #  ",
                        "     #  ",
                        "     #  ",
                        "     #  ",
                        "   #####"
                )));

        m.put('2', new ArrayList<String>(
                Arrays.asList(
                        "  ##### ",
                        " #     #",
                        "       #",
                        "  ##### ",
                        " #      ",
                        " #      ",
                        " #######"
                )));

        m.put('3', new ArrayList<String>(
                Arrays.asList(
                        "  ##### ",
                        " #     #",
                        "       #",
                        "  ##### ",
                        "       #",
                        " #     #",
                        "  ##### "
                )));

        m.put('4', new ArrayList<String>(
                Arrays.asList(
                        " #      ",
                        " #    # ",
                        " #    # ",
                        " #    # ",
                        " #######",
                        "      # ",
                        "      # "
                )));

        m.put('5', new ArrayList<String>(
                Arrays.asList(
                        " #######",
                        " #      ",
                        " #      ",
                        " ###### ",
                        "       #",
                        " #     #",
                        "  ##### "
                )));

        m.put('6', new ArrayList<String>(
                Arrays.asList(
                        "  ##### ",
                        " #     #",
                        " #      ",
                        " ###### ",
                        " #     #",
                        " #     #",
                        "  ##### "
                )));

        m.put('7', new ArrayList<String>(
                Arrays.asList(
                        " #######",
                        " #    # ",
                        "     #  ",
                        "    #   ",
                        "   #    ",
                        "   #    ",
                        "   #    "
                )));


        m.put('8', new ArrayList<String>(
                Arrays.asList(
                        "  ##### ",
                        " #     #",
                        " #     #",
                        "  ##### ",
                        " #     #",
                        " #     #",
                        "  ##### "
                )));

        m.put('9', new ArrayList<String>(
                Arrays.asList(
                        "  ##### ",
                        " #     #",
                        " #     #",
                        "  ######",
                        "       #",
                        " #     #",
                        "  ##### "
                )));


        BANNER = new Font(8, 7, "BANNER", Collections.unmodifiableMap(m));


    }


}
