package training;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreeThreads {
    static class Worker {
        private final String name;
        private final int delay;

        Worker(String name, int delay) {
            this.name = name;
            this.delay = delay;
        }

        public CompletableFuture<String> run() {
            return CompletableFuture.supplyAsync(() -> {
                System.out.printf("Start %s\r\n", name);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Finished %s\r\n", name);
                return name;
            });
        }
    }

    public static void main(String[] args) {
        CompletableFuture<Object> onlyOne = CompletableFuture.anyOf(
                new Worker("worker 1", 100).run(),
                new Worker("worker 2", 2000).run(),
                new Worker("worker 3", 1000).run()
        );
        try {
            System.out.println("Winner is " + onlyOne.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
