package Stage1_110225_040425.Lesson7.synchronization.base;

public class IncrementTwoCounterSynchronizedDemo {

    static Integer counter = 0;
    static Integer anotherCounter = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                incrementAnother();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("COUNTER: " + counter);
        System.out.println("ANOTHER_COUNTER: " + counter);
        System.out.println("Time elapsed: " + duration);
    }

    private static void increment() {
        synchronized (IncrementTwoCounterSynchronizedDemo.class) {
            counter++;
        } //synchronized блок
    }

    private static void incrementAnother() {
        synchronized (IncrementTwoCounterSynchronizedDemo.class) {
            anotherCounter++;
        } //synchronized блок
    }
}
