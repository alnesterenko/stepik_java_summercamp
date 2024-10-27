package training;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JustTraining {

    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        if ((s1.equals(s2)) || (s1.length() == 1 && s2.indexOf(s1) != -1)) {
            result = true;
        } else {
            List<Character> s1Set = s1.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toCollection(ArrayList::new));
            int s1Length = s1.length();
            int workingLength = s2.length() - s1Length + 1;
            for (int i = 0; i < workingLength; i++) {
                String window = s2.substring(i, i + s1Length);
                if (isIdenticalSet(window, s1Set) && !s1.equals(window)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isIdenticalSet(String window, List<Character> s1Set) {
        List<Character> windowSet = window.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));
        return windowSet.equals(s1Set);
    }

    public static void main(String[] args) {
        JustTraining test = new JustTraining();
        System.out.println(test.checkInclusion("hello", "ooolleoooleh"));
        System.out.println(test.checkInclusion("a", "ab"));
    }
}
