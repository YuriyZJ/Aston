package Stage1_110225_040425.Lesson5.Task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("яблоко", "банан", "апельсин", "киви", "гранат");

        List<String> result = words.stream()
                .filter (word -> word.toLowerCase().startsWith("а")) // поиск "а" + игнорируем регистр
                .map (word -> word.toUpperCase()) // .map(String::toUpperCase) преобразование в верхний регистр
                .collect(Collectors.toList()); // преобразует поток в список, который можно сохранить в переменную или использовать дальше.

        System.out.println(result);
    }
}
