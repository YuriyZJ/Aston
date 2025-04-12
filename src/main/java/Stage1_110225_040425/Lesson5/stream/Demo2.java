package Stage1_110225_040425.Lesson5.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo2 {

    public static void main(String[] args) {

//        error();
        lazy();
    }

    private static void error() {
        List<String> list = Arrays.asList("один", "два", "три");
        Stream<String> stream = Stream.of("один", "два", "три");

        Stream<String> skip = list.stream()
                .map(x -> {
                    System.out.println(x + x);
                    return x + x;
                })
                .skip(1);

//        System.out.println("All elements: " + skip);
        Stream<String> stream1 = list.stream();

        stream1.forEach(System.out::println); // Это терминальная операция.
// Попытка использовать стрим снова вызовет ошибку.
// Например, следующий код вызовет ошибку IllegalStateException.
        stream1.forEach(System.out::println);
    }
    private static void lazy() {
        Stream<String> stream = Stream.of("один", "два", "три");
        System.out.println("Staring print element of steam");
        Stream<String> peek = stream.peek(System.out::println);// Промежуточная операция.
        System.out.println("Finish print element of steam");
        peek.toList();
    }
}
