package training;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SlidingWindows {

    BiFunction<Integer, Integer, Integer> decrease = (oldValue, newValue) -> oldValue - newValue;
    BiFunction<Integer, Integer, Integer> increase = (oldValue, newValue) -> oldValue + newValue;

    public int characterReplacement(String s, int k) {
        int maxLengthOfSubstring = 0;
        int leftCursor = 0;
        int rightCursor = 0;
        int countOfWrongCharacter = 0;
        Map<Character, Integer> map = new HashMap<>();
        int sLength = s.length();
        while (rightCursor < sLength) {
            char tempChar = s.charAt(rightCursor);
            if (map.isEmpty()) {
                map.put(tempChar, 1);
            } else {
                changeCountInMap(map, tempChar, increase);
                if (tempChar != getMaxUsedChar(map)) {
                    countOfWrongCharacter++;
                }
            }
            if (countOfWrongCharacter > k) {
                changeCountInMap(map, s.charAt(leftCursor), decrease);
                leftCursor++;
                countOfWrongCharacter--;
            }
            maxLengthOfSubstring = Math.max(maxLengthOfSubstring, (map.get(getMaxUsedChar(map)) + countOfWrongCharacter));
            rightCursor++;
        }
        return maxLengthOfSubstring;
    }

    public void changeCountInMap(Map<Character, Integer> map, Character character, BiFunction biFunction) {
        map.merge(character, 1, biFunction);
        if (map.get(character) <= 0) {
            map.remove(character);
        }
    }

    public Character getMaxUsedChar(Map<Character, Integer> map) {
        int maxUsed = -1;
        Character tempChar = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int tempEntryValue = entry.getValue();
            if (tempEntryValue > maxUsed) {
                maxUsed = tempEntryValue;
                tempChar = entry.getKey();
            }
        }
        return tempChar;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        SlidingWindows slidingWindows = new SlidingWindows();
        int result = slidingWindows.characterReplacement(s, k); // ответ 4
        System.out.println(result);

        s = "AABABBA";
        k = 1;
        result = slidingWindows.characterReplacement(s, k); // ответ 4
        System.out.println(result);

        s = "AABABCBA";
        k = 2;
        result = slidingWindows.characterReplacement(s, k); // ответ 5
        System.out.println(result);
    }
}
