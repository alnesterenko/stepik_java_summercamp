package training;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindows {

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> resultList = new ArrayList<>();
        int[] slidingWindowArr = new int[k];
        for (int i = 0; i < nums.length - (k - 1); i++) {
            System.arraycopy(nums, i, slidingWindowArr, 0, k);
            Arrays.sort(slidingWindowArr);
            resultList.add(toBigDecimalAndBack(slidingWindowArr, k));
        }
        return resultList.stream().mapToDouble(i -> i).toArray();
    }

    private double toBigDecimalAndBack(int[] slidingWindowArr, int k) {
        BigDecimal resultBD;
        if (k % 2 == 0) {
            resultBD = new BigDecimal((slidingWindowArr[slidingWindowArr.length / 2 - 1] / 2) + (slidingWindowArr[slidingWindowArr.length / 2] / 2));
        } else {
            resultBD = new BigDecimal(slidingWindowArr[slidingWindowArr.length / 2]);
        }
        resultBD = resultBD.setScale(5, RoundingMode.DOWN);
        return resultBD.doubleValue();
    }

    public static void main(String[] args) {
       int[] nums = {2147483647, 2147483647};
       int k = 2;
       SlidingWindows slidingWindows = new SlidingWindows();
       double[] result = slidingWindows.medianSlidingWindow(nums, k);
        for (double oneDigite : result) {
            System.out.println(oneDigite);
        }
        /*System.out.println("------------------------");
        double value = 1.0;
        BigDecimal resultBD = new BigDecimal(value);
        resultBD = resultBD.setScale(5, RoundingMode.DOWN);
        System.out.println(resultBD);
        System.out.println(resultBD.doubleValue());*/
    }
}
