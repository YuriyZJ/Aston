package  Lesson3.clone;

public class CloneCarDeepDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        CarDeep car = new CarDeep("Грузовик", new Driver("Василий", 45));
        CarDeep clonedCar = car.clone();
        System.out.println("Оригинал:\t" + car);
        System.out.println("Клон:   \t" + clonedCar);

        Driver clonedCarDriver = clonedCar.getDriver();
        clonedCarDriver.setName("Артем");

        System.out.println("Оригинал после изменения имени водителя:\t" + car);
        System.out.println("Клон после изменения имени водителя:   \t\t" + clonedCar);
    }
}
