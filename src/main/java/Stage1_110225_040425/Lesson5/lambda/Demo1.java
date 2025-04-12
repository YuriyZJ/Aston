package Stage1_110225_040425.Lesson5.lambda;

public class Demo1 {
    public static void main(String[] args) {

        Operationable operation = (x, y) -> x + y;

        extracted(operation);
    }

    private static void extracted(Operationable operation) {
        int result = operation.calculate(10, 20);
        System.out.println(result);
    }
}
