package  Lesson3.opp.encapsulation;

public class Demo {
    public static void main(String[] args) {
        SomePhone mts = new SomePhone(2024, "MTS");
        mts.ring();
        mts.call();
        System.out.println(mts.toString());
    }
}
