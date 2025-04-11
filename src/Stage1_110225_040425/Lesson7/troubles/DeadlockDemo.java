package Stage1_110225_040425.Lesson7.troubles;

import Stage1_110225_040425.Lesson7.troubles.model.SyncThread;

public class DeadlockDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        Thread t1 = new Thread(new SyncThread(o1, o2), "T1");
        Thread t2 = new Thread(new SyncThread(o3, o1), "T2");

        t1.start();
        t2.start();
    }
}
