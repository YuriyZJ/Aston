package Stage1_110225_040425.Lesson7.threads.priority.worker;

public class ThreadCounterWithPriorityWorker extends Thread {

    private final String name;
    private final int range;

    public ThreadCounterWithPriorityWorker(String name, int range, int priority) {
        this.name = name;
        this.range = range;
        super.setPriority(priority);
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
        }
    }
}
