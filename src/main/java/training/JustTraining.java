package training;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JustTraining {

    public record Line(String level, String threads, String text) { }

    public Line parse(String text) {
        int openingBrackets = 0, closingBrackets = 0, positiEndThreads = 0;
        String level = "";
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            level = text.substring(matcher.start(), matcher.end());
        }
        int positionOfFirstSpace = text.indexOf(' ');
        char tempSymbol = ' ';
        for (int i = positionOfFirstSpace + 1; i < text.length(); i++) {
            tempSymbol = text.charAt(i);
            if (tempSymbol == '[') {
                openingBrackets++;
            }
            if (tempSymbol == ']') {
                closingBrackets++;
            }
            if (openingBrackets == closingBrackets && openingBrackets > 0) {
                positiEndThreads = i;
                break;
            }
        }
        return new Line(level,
                text.substring(positionOfFirstSpace + 1, positiEndThreads + 1),
                text.substring(positiEndThreads + 2));
    }

    public static void main(String[] args) {
        JustTraining training = new JustTraining();
        System.out.println(training.parse("WARNING [threads [zqfz [wbye [zfq]]] - 1] wqqa [e] zqw"));

        /*try (BufferedReader input = new BufferedReader(new FileReader("data/input.txt"))) {
            input.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter output = new BufferedWriter(new FileWriter("data/output.txt"))) {
            String str1 = "я у мамы дурачок";
            String str2 = "ты у мамы дурачок";
            String unionString = String.format("%s%n%s", str1, str2);
            output.write(unionString);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
