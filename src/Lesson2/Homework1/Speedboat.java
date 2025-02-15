package Lesson2.Homework1;

public class Speedboat extends TransportVehicle implements Cargo, Screw{

    public Speedboat(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("I'm going to swim");
    }

    @Override
    public void cargo() {
        Cargo.super.cargo();
    }

    @Override
    public void screw() {
        Screw.super.screw();
    }
}
