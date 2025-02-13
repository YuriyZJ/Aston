package Lesson2.nested;

public class LocalMethodInnerClassDemo {
    // Метод экземпляра внешнего класса
    void myMethod() {
        int num = 888;

        // Локальный метод внутреннего класса
        class MethodInner {
            public void print() {
                System.out.println("Это метод внутреннего класса: " + num);
            }
        } // Конец внутреннего класса

        // Доступ к внутреннему классу
        MethodInner inner = new MethodInner();
        inner.print();
    }

    public static void main(String[] args) {
        LocalMethodInnerClassDemo outer = new LocalMethodInnerClassDemo();
        outer.myMethod();

    }
}
