package Stage1_110225_040425.Lesson7.synchronization.exchanger;

import Stage1_110225_040425.Lesson7.synchronization.exchanger.model.PingWorker;
import Stage1_110225_040425.Lesson7.synchronization.exchanger.model.PongWorker;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class ExchangerDemo {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();

        Exchanger<AtomicInteger> exchanger = new Exchanger<>();
        PingWorker ping = new PingWorker(counter, exchanger);
        PongWorker pong = new PongWorker(counter, exchanger);

        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);

        t1.start();
        t2.start();
    }

}
