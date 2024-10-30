package training;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class SlidingWindows {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int windowMax;
        int numLength = nums.length;
        int lengthOfResultArr = numLength - k + 1; // вычисление размера результирующего массива
        int[] resultArr = new int[lengthOfResultArr];
        if (numLength == 0 || k == 0) {
            resultArr = new int[]{nums[0]};
        } else if (numLength == 1) {
            resultArr = nums;
        } else {
            for (int i = 0; i < numLength - k + 1; i++) {
                windowMax = nums[i];
                for (int j = i; j < k + i; j++) {
                   windowMax = Math.max(windowMax, nums[j]);
                }
                resultArr[i] = windowMax;
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 9, 9, 5, 6, 7, 8, 9}; // старый ответ 24
        int k = 3;
        SlidingWindows slidingWindows = new SlidingWindows();
        int[] resultArr = slidingWindows.maxSlidingWindow(nums, k);
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int oneDigit : resultArr) {
            stringJoiner.add(String.valueOf(oneDigit));
        }
        System.out.println(stringJoiner.toString());
    }
}
