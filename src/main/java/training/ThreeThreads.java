package training;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreeThreads {
    public static AtomicBoolean haveWinner = new AtomicBoolean(false);
    public static String nameOfWinner = null;

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            threadList.add(
                    new Thread(() -> {
                                        try {
                                            Thread.sleep(finalI * 100);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    if (haveWinner.compareAndSet(false, true)) {
                                        nameOfWinner = Thread.currentThread().getName();
                                    }
                            }
                    )
            );
        }
        for (Thread oneThread : threadList) {
            oneThread.start();
        }
        for (Thread oneThread : threadList) {
            try {
                oneThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Победитель: " + nameOfWinner);
    }
}
