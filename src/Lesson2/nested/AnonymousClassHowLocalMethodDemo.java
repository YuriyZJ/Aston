package Lesson2.nested;

public class AnonymousClassHowLocalMethodDemo {
    public void displayMessage(Message m) {
        System.out.println(m.greet() +
                ", это пример анонимного внутреннего класса в качестве аргумента");
    }

    public static void main(String[] args) {
        // Создание класса
        AnonymousClassHowLocalMethodDemo obj = new AnonymousClassHowLocalMethodDemo();

        // Передача анонимного внутреннего класса в качестве аргумента
        Message m = new Message() {
            @Override
            public String greet() {
                return "Привет";
            }
        };
        obj.displayMessage(m);
    }
}
