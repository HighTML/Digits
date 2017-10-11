package com.hightml.digits;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Line {
    List<Digit> digits = new ArrayList<Digit>();

    public Line(String rawline1, String rawline2, String rawline3) {
        assert(rawline1.length()%Digit.WIDTH==0);
        assert(rawline2.length()%Digit.WIDTH==0);
        assert(rawline3.length()%Digit.WIDTH==0);

        String[] parts1 = rawline1.split("(?<=\\G.{"+Digit.WIDTH+"})");
        String[] parts2 = rawline2.split("(?<=\\G.{"+Digit.WIDTH+"})");
        String[] parts3 = rawline3.split("(?<=\\G.{"+Digit.WIDTH+"})");



        for (int i=0; i<parts1.length; i++) {
            digits.add(new Digit(parts1[i], parts2[i], parts3[i]));
        }
    }
}
