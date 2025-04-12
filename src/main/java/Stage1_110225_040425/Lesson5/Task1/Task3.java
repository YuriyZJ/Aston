package Stage1_110225_040425.Lesson5.Task1;

import java.util.Comparator;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 6, 2, 8, 5, 10, 7);

        numbers.stream()
                .filter(number -> number % 2 == 0) // Оставляем только четные числа
                .map(number -> (int) Math.pow(number, 2)) // Возводим в квадрат
                .sorted(Comparator.reverseOrder()) // Сортируем по убыванию
                .forEach(number -> System.out.println(number)); // Выводим результат
    }
}
