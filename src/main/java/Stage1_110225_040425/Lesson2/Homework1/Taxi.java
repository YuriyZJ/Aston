package Stage1_110225_040425.Lesson2.Homework1;

public class Taxi extends TransportVehicle implements Wheel{

    public Taxi(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("Taxi go");
    }

    @Override
    public void wheel() {
        Wheel.super.wheel();
    }
}
