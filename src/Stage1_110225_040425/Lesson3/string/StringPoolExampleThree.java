package  Stage1_110225_040425.Lesson3.string;

public class StringPoolExampleThree {

    public static void main(String[] args) {
        String str1 = "TopJava";
        String str2 = "Java";
        String str3 = "Top" + str2;

        System.out.println("Строка 1 равна строке 3? " + (str1 == str3));
    }
}
