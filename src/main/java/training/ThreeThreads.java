package training;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreeThreads {
    public static volatile AtomicBoolean haveWinner = new AtomicBoolean(false);
    public static String nameOfWinner = null;
    public static ThreadLocal<Integer> pause = new ThreadLocal<>();
    public static final int COUNT = 100;

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 3; i > 0; i--) {
            int finalI = i;
            threadList.add(
                    new Thread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    pause.set(finalI);
                                    int localCount = COUNT;
                                    while (!haveWinner.get() && localCount != 0) {
                                        try {
                                            Thread.sleep(pause.get());
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        localCount--;
                                    }
                                    if (haveWinner.compareAndSet(false, true)) {
                                        nameOfWinner = Thread.currentThread().getName();
                                        System.out.println("!!! haveWinner: " + haveWinner.get()
                                                + " поток " + Thread.currentThread().getName());
                                    }
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
