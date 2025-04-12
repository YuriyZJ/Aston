package Stage1_110225_040425.Lesson5.Task1;

import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, -3, 12, 8, -1, 10, -100);

        numbers.stream()
                .filter(n -> n >= 0) // оставляем неотрицательные
                .map(n -> n * 2) // умножаем на 2
                .forEach(System.out::println);
    }
}
