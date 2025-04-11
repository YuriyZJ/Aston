package Stage1_110225_040425.Lesson2.nested;

public class ClassWithInnerClass {

    private class InnerClass {
        private long l;

        public InnerClass(long l) {
            this.l = l;
        }

        public void print() {
            System.out.println("Это внутренний класс " + l);
        }
    }

    // Доступ к внутреннему классу из метода
    void displayInner() {
        InnerClass inner = new InnerClass(1);
        inner.print();
        InnerClass inner2 = new InnerClass(2);
        inner2.print();
    }

}
