package  Stage1_110225_040425.Lesson3.wrapper;

public class NumberDemo {
    public static void main(String[] args) {
        long int3 = 127l;
        Long int2 = 127L;
        Long int1 = Long.valueOf(127L);
        System.out.println(int1 == int2);
        System.out.println(int1 == int3);


//        compare(int1);
        Integer i = Integer.valueOf(124);

//        int i2 = 124;
//        System.out.println(i == i2);

    }

    static void compare(int i) {
        if (i > 10) {
            System.out.println("Number more 10");
        }
    }

    static void compare(long i) {
        if (i > 10) {
            System.out.println("Number more 10");
        }
    }
}
