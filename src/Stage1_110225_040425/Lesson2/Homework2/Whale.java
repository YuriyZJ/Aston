package Stage1_110225_040425.Lesson2.Homework2;

public class Whale extends Mammal implements Aquatic{

    public Whale(String name) {
        super(name);
    }

    @Override
    public void aquatic() {
        Aquatic.super.aquatic();
    }
}
