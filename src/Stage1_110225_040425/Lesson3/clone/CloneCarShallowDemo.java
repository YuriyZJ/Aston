package  Stage1_110225_040425.Lesson3.clone;

public class CloneCarShallowDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        CarShallow car = new CarShallow("Грузовик", new Driver("Василий", 45));
        CarShallow clonedCar = car.clone();
        System.out.println("Оригинал:\t" + car);
        System.out.println("Клон:   \t" + clonedCar);

        Driver clonedCarDriver = clonedCar.getDriver();
        clonedCarDriver.setName("Артем");
//
        System.out.println("Оригинал после изменения имени водителя:\t" + car);
        System.out.println("Клон после изменения имени водителя:   \t\t" + clonedCar);

        clonedCar.setName("Легковая машина");

        System.out.println("Оригинал после изменения названия машины клона:\t" + car);
        System.out.println("Клон после изменения  названия машины клона:   \t\t" + clonedCar);
    }
}
