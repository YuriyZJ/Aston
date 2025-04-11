package Stage1_110225_040425.Lesson2.Homework1;

public class Aircraft extends TransportVehicle implements Wheel, Screw, Wing, Cargo{

    public Aircraft(String name) {
        super("name");
    }

    @Override
    public void move(){
        System.out.println("I'm going to fly");
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

    @Override
    public void wing() {
        Wing.super.wing();
    }
}
