package  Lesson5.lambda;

public class Demo4 {
    public static void main(String[] args) {

        OperationableGeneric<Integer> operation1 = (x, y)-> x + y;
        OperationableGeneric<String> operation2 = (x, y) -> x + y;

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate("20", "10")); //2010
    }
}
