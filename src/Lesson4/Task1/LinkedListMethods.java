package Lesson4.Task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListMethods {
    public static void main(String[] args) {
        List<String> linkedList1 = new LinkedList<>();

        linkedList1.add("Java");
        linkedList1.add("Python");
        linkedList1.add("C++");
        linkedList1.add("C#");
        linkedList1.add("PHP");

        List<String> linkedList2 = new ArrayList();
        linkedList2.add("Python");
        linkedList2.add("C++");
        linkedList2.add("C#");
        linkedList2.add("PHP");

        linkedList1.add(0, "Go");
        linkedList1.addLast("Ruby");
        linkedList1.add(linkedList1.size()/2, "Rust");
        linkedList1.remove("Go");
        linkedList1.removeAll(linkedList2);

        System.out.println(linkedList1);
    }

}
