package Lesson2.Homework2;

public class Fish extends Animal implements Aquatic{

    public Fish(String name) {
        super(name);
    }

    @Override
    public void aquatic() {
        Aquatic.super.aquatic();
    }
}
