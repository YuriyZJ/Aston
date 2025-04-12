package Stage1_110225_040425.Lesson2.nested.InnerClass;

class Outer {
    private String message = "Привет из внешнего класса!";

    class Inner {
        void printMessage() {
            System.out.println(message); // Может обращаться к нестатическим полям
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Создание объекта
        inner.printMessage();
    }
}

