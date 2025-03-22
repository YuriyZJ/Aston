package Lesson7.callablefuture.task;

import java.util.Random;
import java.util.concurrent.Callable;

public class GenerateRandomIntegerCallableTask implements Callable<Integer> {
    private final Random random = new Random();
    @Override
    public Integer call() {
        try {
            Thread.sleep(100);
            int randomInt = random.nextInt(1000) + 1;
            System.out.println("Thread run : " + Thread.currentThread().getName() + ". Result" + randomInt);
            return randomInt;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
