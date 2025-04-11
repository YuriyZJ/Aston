package Stage1_110225_040425.Lesson7.forkjoin;

public class SumStandardDemo {
    public static void main(String[] args) {
        int arraySize = 1_000_000_000;
        int[] arr = new int[arraySize];

        fillArray(arr);

        long start = System.currentTimeMillis();
        long calculateSum = 0;

        for (int i = 0; i < arraySize; i++) {
            calculateSum += arr[i];
        }

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

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    private static long gaussSum(int n) {
        return (long) n * (n + 1) / 2;
    }
}
