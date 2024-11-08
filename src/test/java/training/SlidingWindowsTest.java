package training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;


class SlidingWindowsTest {

    static Map<Character, Integer> testingMap;

    BiFunction<Integer, Integer, Integer> decrease = (oldValue, newValue) -> oldValue - newValue;
    BiFunction<Integer, Integer, Integer> increase = (oldValue, newValue) -> oldValue + newValue;

    @BeforeEach
    public void init() {
        testingMap = new HashMap<>();
        testingMap.put('C', 1);
    }

    @Test
    public void whenDeleteOneCCharacter() {
        SlidingWindows slidingWindows = new SlidingWindows();
        slidingWindows.changeCountInMap(testingMap, 'C', decrease);
        assertThat(testingMap.size()).isEqualTo(0);
    }

    @Test
    public void whenDeleteOneCCharacterTwice() {
        SlidingWindows slidingWindows = new SlidingWindows();
        slidingWindows.changeCountInMap(testingMap, 'C', decrease);
        slidingWindows.changeCountInMap(testingMap, 'C', decrease);
        assertThat(testingMap.size()).isEqualTo(1);
    }

    @Test
    public void whenAddOneCAndDCharacters() {
        SlidingWindows slidingWindows = new SlidingWindows();
        slidingWindows.changeCountInMap(testingMap, 'C', increase);
        slidingWindows.changeCountInMap(testingMap, 'D', increase);
        assertThat(testingMap.size()).isEqualTo(2);
        assertThat(testingMap.get('C')).isEqualTo(2);
        assertThat(testingMap.get('D')).isEqualTo(1);
    }

    @Test
    public void whenC2AndD1() {
        SlidingWindows slidingWindows = new SlidingWindows();
        slidingWindows.changeCountInMap(testingMap, 'C', increase);
        slidingWindows.changeCountInMap(testingMap, 'D', increase);
        assertThat(slidingWindows.getMaxUsedChar(testingMap)).isEqualTo('C');
    }

    @Test
    public void whenC1AndD1() {
        SlidingWindows slidingWindows = new SlidingWindows();
        slidingWindows.changeCountInMap(testingMap, 'D', increase);
        assertThat(slidingWindows.getMaxUsedChar(testingMap)).isEqualTo('C');
        assertThat(testingMap.size()).isEqualTo(2);
    }

    @Test
    public void whenMapIsEmpty() {
        SlidingWindows slidingWindows = new SlidingWindows();
        slidingWindows.changeCountInMap(testingMap, 'C', decrease);
        Character result = slidingWindows.getMaxUsedChar(testingMap);
        assertThat(result).isNull();
    }
}