package Stage1_110225_040425.Lesson5.javaFunctionalInterface;

import java.util.function.UnaryOperator;

public class DemoUnaryOperator {

    public static void main(String[] args) {

        UnaryOperator<Integer> square = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(square.apply(5)); // 25
    }
}
