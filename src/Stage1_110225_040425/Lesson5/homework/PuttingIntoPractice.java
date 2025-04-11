package  Stage1_110225_040425.Lesson5.homework;

import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List <Transaction> transactions2011 = transactions.stream()
                .filter (year -> year.getYear() == 2011)
                .sorted(Comparator.comparing(value -> value.getValue()))
                .collect(Collectors.toList());

        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        Set<String> citiesTraders = transactions.stream()
                .map(city -> city.getTrader().getCity())
                .collect(Collectors.toSet());

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> traders = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct() // возвращает только уникальные данные
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String sortTraders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        //5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean traderFromMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));


        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        int getSumTransactionCambridge = transactions.stream()
                .filter(trader -> trader.getTrader().getCity().equals("Cambridge"))
                .mapToInt(transaction -> transaction.getValue())
                .sum();


        //7. Какова максимальная сумма среди всех транзакций?
        int maxTransactionValue = transactions.stream()
                .mapToInt(transaction1 -> transaction1.getValue())
                .max()
                .orElse(0);

        //8. Найти транзакцию с минимальной суммой.
        Optional<Transaction> transactionMin = transactions.stream()
                .min(Comparator.comparing(transaction -> transaction.getValue()));

        // Вывод результатов
        System.out.println("Транзакции 2011 года: " + transactions2011);
        System.out.println("Города трейдеров: " + citiesTraders);
        System.out.println("Трейдеры из Кембриджа: " + traders);
        System.out.println("Все имена трейдеров: " + sortTraders);
        System.out.println("Есть ли трейдеры из Милана? " + traderFromMilan);
        System.out.println("Сумма транзакций трейдеров из Кембриджа: " + getSumTransactionCambridge);
        System.out.println("Максимальная сумма транзакции: " +maxTransactionValue );
        transactionMin.ifPresent(t -> System.out.println("Транзакция с минимальной суммой: " + t));
    }
}
