package concurent;

import java.util.concurrent.ForkJoinPool;

// Для запуска через командную строку
// Сначало скомпелировать, а затем запускать готовый *.class
// из папки C:\java\stepik_java_summercamp_1_1\target\classes
//java concurent.FJE 1 1000


// Демонстрация параллельного выполнения.
class FJE {
    public static void main(String[] args) {
        int pLevel;
        int threshold;
        if (args.length != 2) {
            System.out.println("Иcпoльзoвaниe: FJExperiment уровень-параллелизма пороговое-значение");
            return;
        }
        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);
        // Переменные, используемые для измерения времени выполнения задачи .
        long beginT, endT;
        // Создать пул задач. Обратите внимание на установку уровня параллелизма
        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double[] nums = new double[1_000_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        Transform task = new Transform(nums, 0, nums.length, threshold);
        // Начать измерение времени.
        beginT = System.nanoTime();
        // Запустить главную задачу ForkJoinTask.
        fjp.invoke(task);
        // Закончить измерение времени.
        endT = System.nanoTime();
        System.out.println("Уpoвeнь параллелизма: " + pLevel);
        System.out.println("Порог последовательной обработки: " + threshold);
        System.out.println("Oбщee затраченное время: " + (endT - beginT) + " нс");
        System.out.println();
    }
}
