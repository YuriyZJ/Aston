package  Stage1_110225_040425.Lesson5.javaFunctionalInterface;

import java.util.function.BinaryOperator;

public class DemoBinaryOperator {
    public static void main(String[] args) {

        BinaryOperator<Integer> multiply = (x, y) -> x * y;

        extracted(multiply, 3, 5);
        extracted(multiply, 10, -2);
    }

    private static void extracted(BinaryOperator<Integer> multiply, int t, int u) {
        System.out.println(multiply.apply(t, u)); // 15
    }
}
