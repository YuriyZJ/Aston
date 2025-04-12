package Stage1_110225_040425.Lesson7.volatiles;

public class RaceConditionDemo {
    private static volatile boolean running = false;
    public static void main(String[] args) {
//        Integer i = 0;//Порядок действий может быть переопределен JVM. Если переменная i volatile то порядок будет, как указано в коде
//        System.out.println("something");
//        i++;


        var t1 = new Thread(() -> {
        while (!running) {

        }
            System.out.println("Java");
        });

        var t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            running = true;
            System.out.println("I love");
        });

        t1.start();
        t2.start();
    }
}
