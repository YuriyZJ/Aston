package  Lesson3.string;

public class StringBuilderDemo {
    public static void main(String[] args) {
        // Создаем StringBuilder объект
// используя StringBuilder() конструктор
        StringBuilder str = new StringBuilder();
        str.append("Andrey");
// выводим как string
        System.out.println("String = " + str.toString());

// Создаем StringBuilder объект
// используя StringBuilder(CharSequence) конструктор
        StringBuilder str1 = new StringBuilder("Andreyev");

// выводим как string
        System.out.println("String1 = " + str1.toString());

    }
}
