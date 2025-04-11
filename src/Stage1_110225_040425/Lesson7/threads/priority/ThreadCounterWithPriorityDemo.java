package Stage1_110225_040425.Lesson7.threads.priority;

import Stage1_110225_040425.Lesson7.threads.priority.worker.ThreadCounterWithPriorityWorker;

public class ThreadCounterWithPriorityDemo {
    public static void main(String[] args) {
        ThreadCounterWithPriorityWorker worker1 = new ThreadCounterWithPriorityWorker("A", 5000, 1);
        ThreadCounterWithPriorityWorker worker2 = new ThreadCounterWithPriorityWorker("B", 5000, 10);

        worker1.start();//Сигнал JVM что поток находиться в состоянии Runnable
        worker2.start();
        System.out.println("Process is finished!!!");
    }
}
