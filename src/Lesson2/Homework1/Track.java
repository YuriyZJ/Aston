package Lesson2.Homework1;

public class Track extends TransportVehicle implements Cargo{

    public Track(String name){
        super("Track");
    }

    @Override
    public void move() {
        System.out.println("I'm going to move the cargo");
    }

    @Override
    public void cargo() {
        Cargo.super.cargo();
    }
}
