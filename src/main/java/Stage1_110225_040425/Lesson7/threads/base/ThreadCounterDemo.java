package Stage1_110225_040425.Lesson7.threads.base;

import Stage1_110225_040425.Lesson7.threads.base.worker.ThreadCounterWorker;

public class ThreadCounterDemo {
    public static void main(String[] args) {
        ThreadCounterWorker worker1 = new ThreadCounterWorker("A", 15);
        ThreadCounterWorker worker2 = new ThreadCounterWorker("B", 15);

        worker1.start();//Сигнал JVM что поток находиться в состоянии Runnable
        worker2.start();
        System.out.println("Process is finished!!!");
    }
}
