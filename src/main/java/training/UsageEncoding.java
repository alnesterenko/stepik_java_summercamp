package training;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class UsageEncoding {
    /*public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines()
                    .map(string -> string + System.lineSeparator())
                    .forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), false))) {
            data.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UsageEncoding thisClassInstance = new UsageEncoding();
        String path = new String("C:\\java\\stepik_java_summercamp_1_1\\stepik_java_summercamp_1_1\\src\\data\\words.txt");
        List<String> strings = new ArrayList<>();
        strings.add("я у мамы дурачок!");
        strings.add("ты у мамы дурачок!");
        strings.add("тру-ла-ла!");
        thisClassInstance.writeDataInFile(path, strings);
    }*/

    public static void main(String[] args) {
        System.out.println();
    }
}