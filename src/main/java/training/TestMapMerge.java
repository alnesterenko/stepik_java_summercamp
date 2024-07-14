package training;

import java.util.*;

public class TestMapMerge {
    public static void main(String[] args) {
        HashMap<Integer, HashSet<String>> testMap = new HashMap<>();
        HashSet<String> tempSet = new HashSet<>();
        testMap.merge(1, tempSet, (oldValue, newValue) -> new HashSet<>(Arrays.asList("2")));
        testMap.merge(1, tempSet, (oldValue, newValue) -> new HashSet<>(Arrays.asList("3")));
        testMap.merge(2, tempSet, (oldValue, newValue) -> new HashSet<>(Arrays.asList("4")));
        testMap.merge(1, tempSet, (oldValue, newValue) -> new HashSet<>(Arrays.asList("5")));
        testMap.merge(1, tempSet, (oldValue, newValue) -> new HashSet<>(Arrays.asList("6")));

        for (Map.Entry<Integer, HashSet<String>> entry : testMap.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " значение: " + entry.getValue());
        }
    }
}
