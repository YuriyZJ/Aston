package Stage1_110225_040425.Lesson5.lambda;

public class Demo2 {
    public static void main(String[] args) {

        Printable printer = System.out::println;
        printer.print("Hello World from Java !");
    }
}
