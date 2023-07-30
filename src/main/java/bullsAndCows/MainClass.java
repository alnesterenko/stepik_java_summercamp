package bullsAndCows;

import java.util.ArrayList;
import java.util.List;

public class MainClass implements Constants{
    public static void main(String[] args) {
        HiddenNumber hiddenNumber = new HiddenNumber();
        boolean stopTheGame = false;
        int counter = 0;
        List<Integer> tryList = new ArrayList<>();
        System.out.println("Это игра \"Быки и коровы\"! ");
        do {
            UserDigite userDigit = new UserDigite();
            tryList = userDigit.getTryList();
            hiddenNumber.showResult(tryList);
            counter++;
            if (hiddenNumber.getBulls(tryList) == COUNTOFDIGITE) {
                stopTheGame = true;
            }
        } while (!stopTheGame);
        hiddenNumber.winCongratulation(counter);
    }
}
