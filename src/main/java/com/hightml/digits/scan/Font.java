package com.hightml.digits.scan;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Marcel Heemskerk on 12-10-2017.
 */
@Data
@AllArgsConstructor
public class Font {
    public static Font SIMPLE;
    public static Font BANNER;

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

    private int width;
    private int height;
    private String name;
    private Map<Character, List<String>> charMap;

    public Character match(List<String> digitPixels) {
        for (Map.Entry<Character, List<String>> entry : charMap.entrySet()) {
            if (entry.getValue().equals(digitPixels)) return entry.getKey();
        }
        return null;
    }


    public Map<Character, Integer> calculateDistance(List<String> digitPixels) {
        Map<Character, Integer> distances = new HashMap<>();
        String inputPixels = digitPixels.stream().collect(Collectors.joining(""));

        for (Map.Entry<Character, List<String>> entry : charMap.entrySet()) {
            String charPixels = entry.getValue().stream().collect(Collectors.joining(""));

            IntStream inputStream = inputPixels.chars();
            IntStream charStream = charPixels.chars();

            Iterator<Integer> iter1 = inputStream.iterator();
            Iterator<Integer> iter2 = charStream.iterator();
            int distance = 0;
            while (iter1.hasNext() && iter2.hasNext())
                if (!iter1.next().equals(iter2.next()))
                    distance++;

            distances.put(entry.getKey(), distance);
        }

        Map<Character, Integer> sortedDistances =
                distances.entrySet().stream()
                     .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
         // Collectors.toMap will returns a HashMap, return a new LinkedHashMap (keep the order)

        return sortedDistances;
    }



    public List<String> getFontCharacter(Character c) {
        return charMap.get(c);
    }


}
