package training;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreeThreads {
    public static AtomicBoolean haveWinner = new AtomicBoolean(false);
    public static String nameOfWinner = null;
    public static ThreadLocal<Integer> pause = new ThreadLocal<>();
    public static final int COUNT = 1_000;

    public static void main(String[] args) {
        Thread first = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        pause.set(1);
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
                        }
                    }
                }
        );
        Thread second = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        pause.set(1);
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
                        }
                    }
                }
        );
        Thread third = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        pause.set(1);
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
                        }
                    }
                }
        );
        first.start();
        second.start();
        third.start();
        try {
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(nameOfWinner);
    }
}
