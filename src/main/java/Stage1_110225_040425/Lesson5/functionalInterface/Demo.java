package Stage1_110225_040425.Lesson5.functionalInterface;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Start implement method");
        MyInterface myInterface = () -> 2 + 3;
        System.out.println("Finish implement method");

        System.out.println("Start call method");
        int sum = myInterface.getSum();
        System.out.println("Finish call method");
        System.out.println("Result " + sum);

    }
}
