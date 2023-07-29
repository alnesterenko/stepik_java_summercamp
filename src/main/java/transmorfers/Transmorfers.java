package transmorfers;

import java.util.*;

class GetOrDefault {

    private Map<Integer, List<String>> store = new HashMap<>();

    public void addValue(int index, List<String> list) {
        if (getValue(index).size() == 0) {
            store.put(index, list);
        }
    }

    public List<String> getValue(int index) {
        return store.getOrDefault(index, new ArrayList<String>());
    }

    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        List<String> third = List.of("seven", "eight", "nine");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, list);
        get.addValue(2, second);
        get.addValue(1, third);
        List<String> values = get.getValue(1);
        for (String oneValue : values) {
            System.out.println(oneValue);
        }
    }
}