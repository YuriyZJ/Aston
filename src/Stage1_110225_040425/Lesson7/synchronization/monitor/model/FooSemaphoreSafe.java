package Stage1_110225_040425.Lesson7.synchronization.monitor.model;

import java.util.concurrent.Semaphore;

public class FooSemaphoreSafe {
    private final Semaphore betweenFirstAndSecond = new Semaphore(0);
    private final Semaphore betweenSecondAndThird = new Semaphore(0);

    public void first() {
        System.out.println("first");
        betweenFirstAndSecond.release(); //Увеличиваем разрешенные потоки на 1
    }

    public void second() {
        try {
            betweenFirstAndSecond.acquire(); //Уменьшает разрешенные потоки на 1
            System.out.println("second");
            betweenSecondAndThird.release();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    public void third() {
        try {
            betweenSecondAndThird.acquire();
            System.out.println("third");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
