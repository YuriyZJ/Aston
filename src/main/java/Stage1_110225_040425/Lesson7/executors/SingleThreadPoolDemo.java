package Stage1_110225_040425.Lesson7.executors;

import Stage1_110225_040425.Lesson7.executors.task.GenerateRandomIntegerTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try(ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 100; i++) {
                executorService.submit(new GenerateRandomIntegerTask());
            }
        } finally {
            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.println("Processed in: " + duration + " ms");

        }
    }
}
