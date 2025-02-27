package  Lesson5.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        List<String> citiesTraiders = transactions.stream()
                .map(city -> city.getTrader().getCity())
                .collect(Collectors.toList());

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> traiders = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        //5. Выяснить, существует ли хоть один трейдер из Милана.
        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.


        //7. Какова максимальная сумма среди всех транзакций?
        Optional<Transaction> transactionMax = transactions.stream()
                .max(Comparator.comparing(transaction1 -> transaction1.getValue()));

        //8. Найти транзакцию с минимальной суммой.
        Optional<Transaction> transactionMin = transactions.stream()
                .min(Comparator.comparing(transaction -> transaction.getValue()));


    }
}
