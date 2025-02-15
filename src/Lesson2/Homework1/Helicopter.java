package Lesson2.Homework1;

public class Helicopter extends TransportVehicle implements Wheel, Screw, Cargo{

    public Helicopter(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("I'm a turning the blades");
    }

    @Override
    public void cargo() {
        Cargo.super.cargo();
    }

    @Override
    public void screw() {
        Screw.super.screw();
    }

    @Override
    public void wheel() {
        Wheel.super.wheel();
    }
}
