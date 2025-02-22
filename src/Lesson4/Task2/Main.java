package Lesson4.Task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RealizationArrayList<String> arrayList1 = new RealizationArrayList<>();

        arrayList1.add("Java");
        arrayList1.add("Python");
        arrayList1.add("C++");
        arrayList1.add("C#");
        arrayList1.add("PHP");


        arrayList1.add("Go");
        arrayList1.get(0);
        arrayList1.remove(3);

        System.out.println(arrayList1);
        System.out.println(arrayList1.get(0));
        System.out.println();

        List<String> arrayList2 = List.of("Ruby", "JavaScript");
        arrayList1.addAll(arrayList2);
        System.out.println(arrayList1);
        System.out.println();

        arrayList1.bubbleSort();
        System.out.println(arrayList1);
    }
}
