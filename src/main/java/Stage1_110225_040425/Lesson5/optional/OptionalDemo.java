package Stage1_110225_040425.Lesson5.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Car sedan = new Car("sedan");
        License license = new License(sedan, true);
        Driver driver = new Driver("Иванов Иван Иваночич", license);
        //create
        // employee cannot be null
        Optional<Car> optional = Optional.of(new Car());
//        Optional<Car> optionalNull = Optional.of((Car)null);
        // employee can be null
        Optional<Car> nullableOptional = Optional.ofNullable(null);

        Optional<Car> emptyOptional = Optional.empty();

        //transform
        Optional<License> optionalValidLicense = Optional.of(license)
                .filter(License::isValid);

        Optional<String> optionalModel = Optional.ofNullable(sedan)
                .map(Car::getModel);

        Optional<String> optionalModelOther = Optional.ofNullable(null)
                .flatMap(employee -> Optional.ofNullable(sedan.getModel()));

        License license5 = Optional.ofNullable(driver)
                .map(Driver::getLicense)
                .or(() -> Optional.of(new License()))
                .get();

        //check
        boolean hasValue = Optional.ofNullable(driver).isPresent();

        boolean hasValue1 = !Optional.ofNullable(driver).isEmpty();

        //getting
        License license1;
        if (optionalValidLicense.isPresent()) {
            license1 = optionalValidLicense.get();
        }

        try {
            License license2 = optionalValidLicense.get();
        } catch (NoSuchElementException ignored) {
        }

        License newLicense = Optional.ofNullable(license)
                .orElse(new License());

        License newEmployee = Optional.ofNullable(license)
                .orElseGet(() -> optionalValidLicense.orElse(new License()));

            License license2 = Optional.ofNullable((Driver) null)
                    .map(Driver::getLicense)
                    .orElseThrow(IllegalArgumentException::new);

        License license3 = Optional.ofNullable(driver)
                .map(Driver::getLicense)
                .orElseThrow();

        // conditional methods
        Optional.ofNullable(driver)
                .map(Driver::getLicense)
                .ifPresent(license4 -> {
                    System.out.println("License: " + license4);
                });

        Optional.ofNullable((Driver) null)
                .map(Driver::getLicense)
                .ifPresentOrElse(department -> System.out.println("License: " + department.toString()),
                        () -> System.out.println("Unknown license"));

    }
}
