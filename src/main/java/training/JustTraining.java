package training;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JustTraining {

    public record Line(String level, String threads, String text) {
    }

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

    public static void main(String[] args) throws IOException {
        /*JustTraining training = new JustTraining();
        System.out.println(training.parse("WARNING [threads [zqfz [wbye [zfq]]] - 1] wqqa [e] zqw"));*/
        FindInLineDemo.main(args);
    }

    class AvgFile {
        public static void main(String[] args) throws IOException {
            int count = 0;
            double sum = 0.0;

            // Записать выходные данные в файл.
            FileWriter fout = new FileWriter("text.txt");
            fout.write("2 3.4 5 6 7.4 9.1 10.5 done");
            fout.close();

            FileReader fin = new FileReader("test.txt");
            Scanner src = new Scanner(fin);

            // Читать и суммировать числа.
            while (src.hasNext()) {
                if (src.hasNextDouble()) {
                    sum += src.nextDouble();
                    count++;
                } else {
                    String str = src.next();
                    if ("done".equals(str)) {
                        break;
                    } else {
                        System.out.println("Ошибка формата файла.");
                        return;
                    }
                }
            }
            src.close();
            System.out.println("Среднее значение равно " + sum / count);
        }
    }

    class ScanMixed {
        public static void main(String[] args) throws IOException {
            // Запись входных данных в файл.
            FileWriter fout = new FileWriter("stepik_java_summercamp_1_1/src/data/test.txt");
            fout.write("Testing;Scanner;10;12.2\none;true;two;false");
            fout.close();

            FileReader fin = new FileReader("stepik_java_summercamp_1_1/src/data/test.txt");
            Scanner src = new Scanner(fin);

            // Читать до конца.
            while (src.hasNextLine()) {
                String oneLine = src.nextLine();
                Scanner oneWord = new Scanner(oneLine);
                oneWord.useDelimiter(";");
                while (oneWord.hasNext()) {
                    System.out.println(oneWord.next());
                }
                oneWord.close();
                System.out.println("NextLine: ");
            }
            src.close();
        }
    }

    class FindInLineDemo {
        public static void main(String[] args) {
            String instr = "Name: Tom Age: 28 ID: 77";
            Scanner conin = new Scanner(instr);
            // Найти и отобразить возраст.
            conin.findInLine("Age:"); // Найти Age
            if (conin.hasNext()) {
                System.out.println(conin.next());
            } else {
                System.out.println("Ошибка!");
            }
            conin.close();
        }
    }

}
