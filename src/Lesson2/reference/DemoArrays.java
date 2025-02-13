package Lesson2.reference;

public class DemoArrays {
    public static void main(String[] args) {
        int i = 1;
        int i1 = 1;
        if (i == i1) {
            System.out.println("number is equals");
        }
        int[] array = {1,2,3,4};
        int[] array1 = {1,2,3,4};

        if (array1 == array) {
            System.out.println("arrays is equals");
        }
    }
}
