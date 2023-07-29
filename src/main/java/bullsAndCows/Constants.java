package bullsAndCows;

import java.util.List;
import java.util.Map;

public interface Constants {
    int COUNTOFDIGITE = 4;

    default int listToDigite(List<Integer> tempList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempList.size(); i++) {
            stringBuilder.append(tempList.get(i));
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
