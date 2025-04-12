package Stage1_110225_040425.Lesson3.clone;

public class CarShallow implements Cloneable {
    private String name;
    private Driver driver;

    public CarShallow(String name, Driver driver) {
        this.name = name;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public CarShallow clone() throws CloneNotSupportedException {
        return (CarShallow) super.clone();
    }

    @Override
    public String toString() {
        return "CarShallow{" +
                "name='" + name + '\'' +
                ", driver=" + driver +
                '}';
    }
}
