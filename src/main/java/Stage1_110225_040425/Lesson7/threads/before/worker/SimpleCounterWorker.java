package Stage1_110225_040425.Lesson7.threads.before.worker;

public class SimpleCounterWorker {
    private final String name;

    public SimpleCounterWorker(String name) {
        this.name = name;
    }

    public void runCounter(int range) {
        int counter = 0;
        while (counter <= range) {
            System.out.println(name + ": " + counter++);
        }
    }
}
