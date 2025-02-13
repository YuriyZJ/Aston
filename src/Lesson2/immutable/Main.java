package Lesson2.immutable;

public class Main {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;

        s1 = s1 + " World";

        System.out.println(s1);
        System.out.println(s2);


        String s3 = "Test";
        System.out.println(System.identityHashCode(s3));

        s3 = s3 + "123";
        System.out.println(System.identityHashCode(s3));
    }
}

