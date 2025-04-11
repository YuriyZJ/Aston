package Stage1_110225_040425.Lesson6.exception;

import java.util.ArrayList;
import java.util.List;

public class ExceptionRunner {
    public static void main(String[] args) {


//        demoError();
//        demoRuntimeExceptionError();
//        demoRuntimeExceptionErrorWithCatch();


//        try {
            notSafeDeletion(0);

//        } catch (ArithmeticException e) {
//            System.out.printf("%s: %s%n", e.getClass(), e.getMessage());

//        } catch (SomeException e) {
//            System.out.printf("%s: %s%n", e.getClass(), e.getMessage());
//
//        } catch (RuntimeException e) {
//            e.getStackTrace();
//        }

    }

    private static void demoError() {
        Long recursion = recursion(1L);
    }

    private static Long recursion(Long l) {
        if (l == 10000L) {
            return l;
        }
        return l * recursion(++l);
    }

    private static void demoRuntimeExceptionError() {
        System.out.println("Before");
        List<String> srt = new ArrayList<>();
        srt.get(10);
        System.out.println("After");
    }

    private static void demoRuntimeExceptionErrorWithCatch() {
        System.out.println("Before");
        List<String> srt = new ArrayList<>();

        try {
            srt.get(10);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("After");
        }
    }

    private static void notSafeDeletion(int number) throws SomeException {
        if (number == 10) {
            throw new SomeException("My exception");
        }

        System.out.println(9 / number);
    }
}
