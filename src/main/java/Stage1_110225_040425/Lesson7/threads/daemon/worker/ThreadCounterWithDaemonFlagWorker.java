package Stage1_110225_040425.Lesson7.threads.daemon.worker;

public class ThreadCounterWithDaemonFlagWorker extends Thread {
    private final String name;
    private final int range;

    public ThreadCounterWithDaemonFlagWorker(String name, int range, boolean isDaemon) {
        this.name = name;
        this.range = range;
        super.setDaemon(isDaemon);
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
        }
        System.out.println(name + ": COUNTER FINISHED THE WORK");
    }
}
