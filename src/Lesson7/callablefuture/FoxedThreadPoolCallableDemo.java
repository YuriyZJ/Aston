package Lesson7.callablefuture;

import Lesson7.callablefuture.task.GenerateRandomIntegerCallableTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FoxedThreadPoolCallableDemo {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();

        List<Future<Integer>> futures = new ArrayList<>();//куда записываем результат
        long start = System.currentTimeMillis();
        try(ExecutorService executorService = Executors.newFixedThreadPool(cores * 100)) {
            for (int i = 0; i < 100; i++) {
                futures.add(executorService.submit(new GenerateRandomIntegerCallableTask()));
            }
        }

        System.out.println("Get result");
        futures.forEach(integerFuture -> {
            try {
                System.out.println(integerFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                throw  new RuntimeException();
            }
        });

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Processed in: " + duration + " ms");
    }

}
