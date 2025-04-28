package training;

import java.util.ArrayList;
import java.util.List;

public class ThreeThreads {

    private static List<Worker> workers = new ArrayList<>();
    static final Object LOCK = new Object();
    static boolean haveWinner = false;

    static class Worker extends Thread {
        private final String name;
        private final int delay;

        Worker(String name, int delay) {
            this.name = name;
            this.delay = delay;
        }

        @Override
        public void run() {
            System.out.printf("Start %s\r\n", name);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (LOCK) {
                if (!haveWinner) {
                    haveWinner = true;
                    LOCK.notifyAll();
                    System.out.printf("Finished %s\r\n", name);
                }
            }
        }
    }

    private static synchronized void stopAll() {
        workers.forEach((thread) -> {
            if (thread.isAlive()) {
                thread.interrupt();
            }
        });
    }

    public static void main(String[] args) {
        workers = List.of(
                new ThreeThreads.Worker("worker 1", 100),
                new ThreeThreads.Worker("worker 2", 100),
                new ThreeThreads.Worker("worker 3", 100));
        workers.forEach(Thread::start);
        synchronized (LOCK) {
            while (!haveWinner) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        stopAll();
    }
}
