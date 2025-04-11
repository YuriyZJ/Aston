package Stage1_110225_040425.Lesson7.synchronization.exchanger.model;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class PingWorker implements Runnable {
    private final AtomicInteger counter;
    private final Exchanger<AtomicInteger> exchanger;
    private int limit = 0;

    public PingWorker(AtomicInteger counter, Exchanger<AtomicInteger> exchanger) {
        this.counter = counter;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (limit++ < 100) {
            try {
                AtomicInteger exchangerCounter = exchanger.exchange(counter);
                System.out.println("PING: " + exchangerCounter.getAndIncrement());
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}
