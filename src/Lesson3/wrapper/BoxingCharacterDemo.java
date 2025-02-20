package  Lesson3.wrapper;

public class BoxingCharacterDemo {
    public static void main(String[] args) {
        Character character = 'C';      //Boxing char to Character
        char a = character;             //Unboxing Character to char

        System.out.println("character: " + character);
        System.out.println("char a: " + a);
    }
}
