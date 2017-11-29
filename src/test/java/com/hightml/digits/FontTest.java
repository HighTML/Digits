package com.hightml.digits;

import com.hightml.digits.scan.Font;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class FontTest {


    @Test
    public void test1() {
        Font f = Font.SIMPLE;

        List<String> input1 = new ArrayList<>(
                Arrays.asList(
                        " _ ",
                        " _|",
                        "|_ "
                ));


        Map<Character, Integer> distance1 = f.calculateDistance(input1);
        distance1.entrySet().stream().forEach(e -> log.debug("Character {} has distance {}", e.getKey(), e.getValue()));
    }


    @Test
    public void test2() {
        Font f = Font.SIMPLE;

        List<String> input2 = new ArrayList<>(
                Arrays.asList(
                        " _ ",
                        " _ ",
                        "|* "
                ));


        Map<Character, Integer> distance2 = f.calculateDistance(input2);
        log.debug("Distances: {}", distance2);

        distance2.entrySet().stream().forEach(e -> log.debug("Character {} has distance {}", e.getKey(), e.getValue()));

        Character closest = distance2.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();

        log.debug("Closest is {} to match \n{}", closest, String.join("\n", input2));
    }




}

