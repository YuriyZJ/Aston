package Lesson2.interfaces;

import java.io.InputStream;
import java.io.Serializable;

public class ProgramDemo {

    public static void main(String[] args) {


//        Printable printable = new Book("Java. Complete Reference", "H. Shildt");
//        printable.print();      //  Java. Complete Reference (H. Shildt)
//        printable = new Journal("Foreign Policy");
//        printable.print();      // Foreign Policy
//        Searchable searchable = new Book("Java. Complete Reference", "H. Shildt");

        Calculatable c = new Calculation();
        System.out.println(c.sum(1, 2));
        System.out.println(c.sum(1, 2, 4));
    }
}
