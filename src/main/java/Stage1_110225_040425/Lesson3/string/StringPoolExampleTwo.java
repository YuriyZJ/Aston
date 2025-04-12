package Stage1_110225_040425.Lesson3.string;

public class StringPoolExampleTwo {

    public static void main(String[] args) {
        String str1 = "TopJava";
        String str2 = "Top" + "Java";

        System.out.println("Строка 1 равна строке 2? " + (str1 == str2));
    }
}
