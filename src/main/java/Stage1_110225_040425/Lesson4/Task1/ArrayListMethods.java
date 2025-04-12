package Stage1_110225_040425.Lesson4.Task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListMethods {
    public static void main(String[] args) {
    List<String> arrayList1 = new LinkedList<>();

    arrayList1.add("Java");
    arrayList1.add("Python");
    arrayList1.add("C++");
    arrayList1.add("C#");
    arrayList1.add("PHP");

    List<String> arrayList2 = new ArrayList();
    arrayList2.add("Python");
    arrayList2.add("C++");
    arrayList2.add("C#");
    arrayList2.add("PHP");

    arrayList1.add(0,"Go");
    arrayList1.add(arrayList1.size(),"Ruby");
    arrayList1.add(arrayList1.size()/2, "Rust");
    arrayList1.remove(5);
    arrayList1.removeLast();
    arrayList1.removeFirst();
    //arrayList1.clear(); // удаляет все элементы
    arrayList1.remove("C++");
    arrayList1.removeAll(arrayList2); //удаляет несколько элементов перечисленные в переданной коллекции

    System.out.println(arrayList1);
    }
}
