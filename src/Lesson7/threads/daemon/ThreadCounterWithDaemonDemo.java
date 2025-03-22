package Lesson7.threads.daemon;

import Lesson7.threads.daemon.worker.ThreadCounterWithDaemonFlagWorker;

public class ThreadCounterWithDaemonDemo {
    public static void main(String[] args) {
        ThreadCounterWithDaemonFlagWorker worker1 = new ThreadCounterWithDaemonFlagWorker("A", 1000, true);
        ThreadCounterWithDaemonFlagWorker worker2 = new ThreadCounterWithDaemonFlagWorker("B", 100, false);

        worker1.start();
        worker2.start();
        System.out.println("Process is finished!!!");
    }
}
