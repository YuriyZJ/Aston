package Stage1_110225_040425.Lesson5.optional;

public class License {
    private Car car;
    private boolean isValid;

    public License() {
    }

    public License(Car car, boolean isValid) {
        this.car = car;
        this.isValid = isValid;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public String toString() {
        return "License{" +
               "car=" + car +
               ", isValid=" + isValid +
               '}';
    }
}
