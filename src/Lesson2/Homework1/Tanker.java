package Lesson2.Homework1;

public class Tanker extends TransportVehicle implements Cargo, Screw{

    public Tanker(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("I'm shadow fleet and I transfer oil");
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
