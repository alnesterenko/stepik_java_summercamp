package stepik_java_summercamp_1;

import java.io.IOException;
import java.util.*;
import java.math.*;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {

//        Иванов Иван +38056
//        Столяров Сергей +38057
//        Стоянов Илья +38055
//        Сергей Дурдачник +38033

//        Scanner scanner = new Scanner(System.in);
//        TreeMap <String, TreeSet<String>> map = new TreeMap<>();
//
//        for (int i = 0; i < 4; i++) {
//            String s = scanner.nextLine();
//            String [] arrString = s.split(" ");
//            String name = arrString[0] + " " + arrString[1];
//            String number = arrString[2];
//            if (map.containsKey(name)){
//                map.get(name).add(number);
//            }else {
//                TreeSet<String> set = new TreeSet<>();
//                set.add(number);
//                map.put(name, set);
//            }
//        }
//        for (String name :
//                map.keySet()) {
//            System.out.print(name + " : ");
//            for (String number: map.get(name)){
//                System.out.print(number + " ");
//            }
//            System.out.println();
//        }

        Scanner scanner = new Scanner(System.in);
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();
        String [] arrNewFriends = {};

        while (true){
            String line = scanner.nextLine().trim();
            if (line.isEmpty()){
                break;
            }else {
                arrNewFriends = line.split(" ");
                String firstFriend = arrNewFriends[0];
                String secondFriend = arrNewFriends[1];
                if (map.containsKey(firstFriend)){
                    map.get(firstFriend).add(secondFriend);
                }else{
                    TreeSet<String> set = new TreeSet<>();
                    set.add(secondFriend);
                    map.put(firstFriend, set);
                }
                //А теперь друзей меняем местами
                if (map.containsKey(secondFriend)){
                    map.get(secondFriend).add(firstFriend);
                }else{
                    TreeSet<String> set = new TreeSet<>();
                    set.add(firstFriend);
                    map.put(secondFriend, set);
                }


            }
        }
        for (String name : map.keySet()) {
            System.out.print(name + " Дружит с :");
            for (String frend: map.get(name)) {
                System.out.print(" " + frend);
            }
            System.out.println();
        }


    }

}

