package Lesson7.threads.base;

import Lesson7.threads.base.worker.RunnableCounterWorker;

public class RunnableCounterDemo {
    public static void main(String[] args) {
        RunnableCounterWorker runnable1 = new RunnableCounterWorker("A", 15);
        RunnableCounterWorker runnable2 = new RunnableCounterWorker("B", 15);

        Thread thread1 = new Thread(runnable1);//NEW
        Thread thread2 = new Thread(runnable2);
        thread1.start();// Runnable
        thread2.start();
    }
}
