package Stage1_110225_040425.Lesson2.Homework2;

public class Cat extends Mammal implements Wool{

    public Cat(String name) {
        super("Cat");
    }

    @Override
    public void wool() {
        Wool.super.wool();
    }
}
