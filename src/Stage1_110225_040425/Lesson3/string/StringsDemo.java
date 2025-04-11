package Stage1_110225_040425.Lesson3.string;

public class StringsDemo {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str5 = "Hello111";

        System.out.println(str1 == str2);

        str1 = "Hello" + "111";


        System.out.println(str1 == str5);




//        String intern3 = hello3.intern();
//        String intern4 = hello4.intern();
//
//        System.out.println(intern3 == intern4);
//        System.out.println(str1 == intern3);
    }
}
