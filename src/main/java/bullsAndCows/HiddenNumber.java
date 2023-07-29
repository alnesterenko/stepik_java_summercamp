package bullsAndCows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HiddenNumber implements Constants{
    private List<Integer> hidenList = new ArrayList<>();

    public HiddenNumber() {
        this.hidenList = createHidenList();
    }

    public List<Integer> createHidenList() {
        List<Integer> tempList = new ArrayList<>(COUNTOFDIGITE);
        Random random = new Random();
        for (int i = 0; i < COUNTOFDIGITE; i++) {
            int tempDigite = random.nextInt(10);
            if (!tempList.contains(tempDigite)) {
                tempList.add(tempDigite);
            }
        }
        return tempList;
    }

    public List<Integer> getHidenList() {
        return hidenList;
    }

    public int getBulls(List<Integer> digiteList) {
        int bulls = 0;
        for (int i = 0; i < COUNTOFDIGITE; i++) {
            if (hidenList.get(i) == digiteList.get(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    public int getCows(List<Integer> digiteList) {
        int cows = 0;
        for (int i = 0; i < COUNTOFDIGITE; i++) {
            for (int j = 0; j < COUNTOFDIGITE; j++) {
                if (digiteList.get(i) == hidenList.get(j) && i != j) {
                    cows++;
                }
            }
        }
        return cows;
    }

    public void showResult(List<Integer> digiteList) {
        System.out.println(" Быков: " + getBulls(digiteList) + ", коров: " + getCows(digiteList));
    }

    public void winCongratulation() {
        System.err.println(" Вы победили!!!");
        System.err.println(" Загаданное число: " + listToDigite(getHidenList()));
    }
}
