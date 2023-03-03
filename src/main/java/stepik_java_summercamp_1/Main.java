package stepik_java_summercamp_1;

import java.io.IOException;
import java.util.*;
import java.math.*;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {

//        Numbers numbers = new Numbers();
//        int r = numbers.sum(5);
//        System.out.println(r);

        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> map = new TreeMap<>();
        String s = scanner.nextLine();
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                if (map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }else {
                    map.put(s.charAt(i), 1);
                }
            }
        }
        for (Character ch: map.keySet()) {
            System.out.println(ch + ":" + map.get(ch));
        }

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        BigInteger f = new BigInteger("0");
//        BigInteger f1 = new BigInteger("1");
//        BigInteger f2 = new BigInteger("1");
//
//        if (n == 1 || n == 2){
//            System.out.println(1);
//        }else {
//            for (int i = 3; i <= n; i++) {
//                f = f1.add(f2);
//                f2 = f1;
//                f1 = f;
//
//            }
//            System.out.println(f);
//        }



    }

}

