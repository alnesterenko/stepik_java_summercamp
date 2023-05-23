package stepik_java_summercamp_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Numbers {

    //number of divisors

    /*Метод принимает число и возвращает количесво его делителей (без 1 и самого числа)*/
    public static int numberOfDivisors(int num) {
        int count = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }


    /*Метод округляет целое положительное число и выводит его в консоль*/
    public static void roundToZero(int number) {
        int[] ints = splitNumber(number);
        if (ints.length == 1) {
            if (ints[ints.length - 1] > 5) {
                ints[ints.length - 1] = 10;
            } else {
                ints[ints.length - 1] = 0;
            }
        } else {
            if (ints[ints.length - 1] > 5) {
                ints[ints.length - 2]++;
                ints[ints.length - 1] = 0;
            } else {
                ints[ints.length - 1] = 0;
            }
        }
        System.out.println(mergeArrayToInt(ints));
    }

    /*Метод возвращает максимальное значение в переданном массиве*/
    public static int maxInArray(int[] arr) {
        int max = arr[0];
        for (int i :
                arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /*Метод соеденяет массив целых чисел в одно целое число*/
    public static int mergeArrayToInt(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[arr.length - i - 1] * (int) Math.pow(10, i);
        }
        return result;
    }

    /*Метод разбивает число на массив отделных цифр*/
    public static int[] splitNumber(int number) {
        int[] tempIntArr = new int[50];
        int count = 0;
        while (number > 0) {
            tempIntArr[count] = number % 10;
            number /= 10;
            count++;
        }
        int[] intArr = new int[count];
        for (int i = 0; i < count; i++) {
            intArr[i] = tempIntArr[count - 1 - i];
        }
        return intArr;
    }

    /*Метод возвращает массив с делителями переданного в метод числа*/
    public static int[] dividers(int num) {
        int[] workArr = new int[100];
        int start = 0;
        int halfOfNum = num / 2;
        for (int j = 1; j <= halfOfNum; j++) {
            if (num % j == 0) {
                workArr[start++] = j;
            }
        }
        workArr[start] = num;
        int[] returnedArr = new int[start + 1];
        for (int j = 0; j < returnedArr.length; j++) {
            returnedArr[j] = workArr[j];
        }
        return returnedArr;
    }

    /*Метод ищет значение в массиве и возвращает индекс или -1 если ничего не найдено*/
    public static int findValueInArray(int[] arr,int value) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int[][] rows(int count) {
        int[][] triangle = new int[count][];
        int counter = 0;
        for(int i = 0; i < count; i++){
            triangle[i] = new int[i + 1];
            for(int j = 0; j < i + 1; j++){
                triangle[i][j] = ++counter;
            }
        }
        return triangle;
    }

    public static void main(String[] args) {
        int[][] triangle = rows(7);
        for(int i = 0; i < triangle.length; i++){
            for(int j = 0; j < i + 1; j++){
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
