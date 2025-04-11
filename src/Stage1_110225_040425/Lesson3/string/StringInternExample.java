package  Stage1_110225_040425.Lesson3.string;

public class StringInternExample {


    public static void main(String[] args) {
        String str1_1 = "TopJava";
        String str1_2 = "topjava";
        boolean b = str1_1.equalsIgnoreCase(str1_2);
        System.out.println("equalsIgnoreCase - " + b);

        String strHeap = new String("TopJava");
        System.out.println("Строка 1 равна строке 3 до интернирования ? " + (str1_1 == strHeap));
        String str1_3 = strHeap.intern();
        System.out.println("Строка 1 равна строке 3? " + (str1_1 == str1_3));

        String str1_4 = (new String("TopJava")).intern();
        System.out.println("Строка 3 равна строке 4? " + (str1_3 == str1_4));

        String str2_2 = "Java";
        String str2_3 = "interned " + str2_2;
        String str2_1 = "interned Java";


        System.out.println("Строка 1 равна строке 3 до интернирования? " + (str2_1 == str2_3));
        System.out.println("Строка 1 равна строке 3? " + (str2_1 == str2_3.intern()));
    }
}
