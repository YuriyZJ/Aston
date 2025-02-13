package Lesson2.nested.LocalClass;

class Outer {


    void display() {
        class LocalClass {
            void show() {
                System.out.println("Я локальный класс!");
            }
        }
        LocalClass local = new LocalClass();
        local.show();
    }

    void print() {
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display();

    }
}
