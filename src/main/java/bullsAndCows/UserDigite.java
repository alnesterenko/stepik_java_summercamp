package bullsAndCows;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDigite implements Constants {
    private List<Integer> tryList = new ArrayList<>();

    public UserDigite() {
        List<Integer> tempList = new ArrayList<>();
        do {
            System.out.println("Введите четырёх значное число:");
            Scanner in = new Scanner(System.in);
            tempList = intToIntegerList(in.nextLine());
        } while (tempList.size() != COUNTOFDIGITE);
        this.tryList = tempList;
    }

    private List<Integer> intToIntegerList(String str) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            tempList.add(Character.getNumericValue(str.charAt(i)));
        }
        return tempList;
    }

    public List<Integer> getTryList() {
        return tryList;
    }
}
