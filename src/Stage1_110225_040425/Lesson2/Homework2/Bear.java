package Stage1_110225_040425.Lesson2.Homework2;

public class Bear extends Mammal implements Wool{

    public Bear(String name) {
        super("Bear");
    }

    @Override
    public void wool() {
        Wool.super.wool();
    }
}
