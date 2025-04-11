package Stage1_110225_040425.Lesson2.interfaces;

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
