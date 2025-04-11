package  Stage1_110225_040425.Lesson5.optional;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Driver driver = new Driver();
        // possible NullPointerException
        String version = findCarModel(driver);

        // null-safe
        String model = "UNKNOWN";
        if (driver != null) {
            License license = driver.getLicense();
            if (license != null) {
                Car car = license.getCar();
                if (car != null && car.getModel() != null) {
                    model = car.getModel();
                }
            }
        }

        Optional.ofNullable(driver)
                .map(driver1 -> driver1.getLicense())
                .map(License::getCar)
                .ifPresentOrElse(c -> System.out.println(c), () -> System.out.println("Not found"));


    }

    private static String findCarModel(Driver driver) {
        return driver.getLicense().getCar().getModel();
    }
}
