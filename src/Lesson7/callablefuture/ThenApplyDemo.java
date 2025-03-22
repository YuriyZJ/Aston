package Lesson7.callablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ThenApplyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Создание CompletableFuture
        CompletableFuture<String> whatsYourName = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            System.out.println(Thread.currentThread().getName());
            return "Ivanov";
        });

        //Присоединение к предыдущему вызову с использованием thenApply
        CompletableFuture<String> greetingFuture = whatsYourName.thenApply(name -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello " + name;
        });
        System.out.println(Thread.currentThread().getName() + " go further");
        //Блокировка и получение результата Future
        System.out.println(Thread.currentThread().getName() + " " + greetingFuture.get());

    }
}
