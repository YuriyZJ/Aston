package  Lesson5.lambda;

public class Demo3 {
    public static void main(String[] args) {
        Operationable operation = (x, y) -> {
            if (y == 0)
                return 0;
            else
                return x / y;
        };

        System.out.println(operation.calculate(20, 10)); //2
        System.out.println(operation.calculate(20, 0)); //0
    }
}
