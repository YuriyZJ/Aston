package Stage1_110225_040425.Lesson2.nested.staticNestedClass;

class Outer {
    private static String s = "Статик поле";
    static class StaticNested {
        void printMessage() {
            System.out.println(s);
            System.out.println("Я статический вложенный класс!");
        }
    }
}



public class Main {
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.printMessage();
    }
}

