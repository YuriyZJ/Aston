package Stage1_110225_040425.Lesson7.threads.base.worker;

public class ThreadCounterWorker extends Thread {
    private final String name;
    private final int range;

    public ThreadCounterWorker(String name, int range) {
        this.name = name;
        this.range = range;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
        }

        counter = counter + 1;
    }

}
