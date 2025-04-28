package training;

import java.util.List;

public class ReplicationCall {
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
                throw new RuntimeException(e);
            }
            System.out.printf("Finished %s\r\n", name);
        }
    }

    public static void main(String[] args) {
        var workers = List.of(
                new Worker("worker 1", 100),
                new Worker("worker 2", 2000),
                new Worker("worker 3", 1000));
        workers.forEach(Thread::start);
    }
}
