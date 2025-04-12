package Stage1_110225_040425.Lesson2.nested;

public class ClassWithStaticNestedClassDemo {
    private String name;

    static class Engine {
        private String engineName;
        private String engineType;
        private String engineValue;
    }


    public ClassWithStaticNestedClassDemo(String name) {
        this.name = name;
    }

    private static class NestedDemo {
        private String field;

        public NestedDemo(String field) {
            this.field = field;
        }

        public void myMethod() {
            System.out.println("Это мой вложенный класс");
        }
    }

    public static void main(String[] args) {

        ClassWithStaticNestedClassDemo.NestedDemo nested = new ClassWithStaticNestedClassDemo.NestedDemo("new");
        nested.myMethod();

    }
}
