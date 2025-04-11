package Stage1_110225_040425.Lesson7.synchronization.cas;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {
    static AtomicLong counter = new AtomicLong();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                increment();
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
        System.out.println("Time elapsed: " + duration);
    }

//    private static void increment() {
//        counter.addAndGet(1);
//    }

    private static void increment() {
        counter.incrementAndGet();
    }
}
