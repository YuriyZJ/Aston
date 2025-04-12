package Stage1_110225_040425.Lesson7.forkjoin;

import Stage1_110225_040425.Lesson7.forkjoin.model.SumTask;

import java.util.concurrent.ForkJoinPool;

public class SumDemo {
    public static void main(String[] args) {
        int arraySize = 1_000_000_000;
        int[] arr = new int[arraySize];

        fillArray(arr);

        long start = System.currentTimeMillis();
        try(ForkJoinPool executorService = new ForkJoinPool()) {
            long calculateSum = executorService.invoke(new SumTask(arr, 0, arr.length));
            System.out.println("Sum: " + calculateSum);

            long gaussSum = gaussSum(arraySize);
            System.out.println("Gauss sum: " + gaussSum);

            if(gaussSum == calculateSum) {
                System.out.println("Result is correct!");
            }

            long end = System.currentTimeMillis();
            long duration = end - start;
            System.out.println("Processed in: " + duration + " ms");

        }
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    private static long gaussSum(int n) {
        return (long) n * (n + 1) / 2;
    }
}
