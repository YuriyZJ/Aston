package  Lesson3.string;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer firstBuffer = new StringBuffer(); // capacity = 16
        StringBuffer secondBuffer = new StringBuffer("habrahabr"); // capacity = str.length() + 16
        StringBuffer thirdBuffer = new StringBuffer(secondBuffer); // параметр - любой класс, что реализует CharSequence
        StringBuffer fourthBuffer = new StringBuffer(50); // передаем capacity

        String name = "Andrey";
        String surName = "Andreyev";
        StringBuffer buffer = new StringBuffer();
        buffer.append(name + " "); // добавляем имя вместе с пробелом
        buffer.append(surName); // добавляем фамилие
        buffer.delete(buffer.length() - surName.length(), buffer.length()); // удаляем фамилие
        // buffer.delete([стартовый индекс], [индекс конечного символа])

        buffer.insert(buffer.length(), surName); // вставляем строку по определенному индексу
        // buffer.insert([с какого индекса вставить], [cтрока])
    }
}
