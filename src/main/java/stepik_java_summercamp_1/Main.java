package stepik_java_summercamp_1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        leftNumChange(123, 456);
    }

    public static int[] splitNumberInArray(int number){
        String strArr[] = Integer.toString(number).split("");
        int size = strArr.length;
        int intArr [] = new int[size];
        for (int i = 0; i < size; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    public static void leftNumChange(int number1, int number2) {
        int arr1[] = splitNumberInArray(number1);
        int arr2[] = splitNumberInArray(number2);

        System.out.println(arr2[0] * 100 + arr1[1] * 10 + arr1[2]);
        System.out.println(arr1[0] * 100 + arr2[1] * 10 + arr2[2]);
    }
}


