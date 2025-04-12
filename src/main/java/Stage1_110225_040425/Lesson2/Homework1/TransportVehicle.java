package Stage1_110225_040425.Lesson2.Homework1;

public abstract class TransportVehicle {
    private String name;

    public TransportVehicle(String name) {
        this.name = name;
    }

    public abstract void move();
}
