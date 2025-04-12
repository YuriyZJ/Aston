package Stage1_110225_040425.Lesson3.clone;

public class CarDeep {
    private String name;
    private Driver driver;

    public CarDeep(String name, Driver driver) {
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
    public CarDeep clone() throws CloneNotSupportedException {
        CarDeep newCar = (CarDeep) super.clone();
        Driver driver = this.getDriver().clone();
        newCar.setDriver(driver);
        return newCar;
    }


    @Override
    public String toString() {
        return "CarDeepClone{" +
                "name='" + name + '\'' +
                ", driver=" + driver +
                '}';
    }
}
