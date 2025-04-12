package Stage1_110225_040425.Lesson7.synchronization.base;

public class IncrementCounterUnsafeDemo {
    static Integer counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
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

        System.out.println("COUNTER: " + counter);
    }

    private static void increment() {
        counter++;
    }
}
