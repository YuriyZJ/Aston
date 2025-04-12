package Stage1_110225_040425.Lesson5.javaFunctionalInterface;

import java.util.function.Consumer;

public class DemoConsumer {
    public static void main(String[] args) {

        Consumer<Integer> printer = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.printf("%d рублей \n", x);
            }
        };
        printer.accept(600); // 600 рублей
    }
}
