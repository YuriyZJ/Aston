package  Lesson5.javaFunctionalInterface;

import java.util.function.Function;

public class DemoFunction {

    public static void main(String[] args) {

        Function<Integer, String> convert = new Function<Integer, String>() {
            @Override
            public String apply(Integer x) {
                return x + " рублей";
            }
        };
        String result = convert.apply(500);
        System.out.println(result); // 5 долларов
    }
}
