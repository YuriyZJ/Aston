package Stage1_110225_040425.Lesson7.synchronization.monitor.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooSafe {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition firstMethodCalled = lock.newCondition();
    private final Condition secondMethodCalled = lock.newCondition();

    public void first() {
        lock.lock();
        try {
            System.out.println("first");
            firstMethodCalled.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second() {
        lock.lock();
        try {
            firstMethodCalled.await();//ждет сигнала из другого потока
            System.out.println("second");
            secondMethodCalled.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void third() {
        lock.lock();
        try {
            secondMethodCalled.await();//ждет сигнала из другого потока
            System.out.println("third");
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }
}
