package Stage1_110225_040425.Lesson2.nested;


public class AnonymousClassDemo {

    public static void main(String[] args) {
        anonymousClass();
    }

    private static void anonymousClass() {
        AnonymousInner inner = new AnonymousInner() {
            public void myMethod() {
                System.out.println("Это пример анонимного внутреннего класса");
            }
        };


        inner.myMethod();
    }
}
