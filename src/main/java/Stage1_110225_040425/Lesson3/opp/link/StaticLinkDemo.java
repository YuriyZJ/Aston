package Stage1_110225_040425.Lesson3.opp.link;

public class StaticLinkDemo {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();
        animal.makeSound(3);

        AnimalActivity.eat(animal);

        Animal dogAnimal = new Dog();
        AnimalActivity.eat(dogAnimal);
//
        Dog dogAnimal1 = (Dog) dogAnimal;
        AnimalActivity.eat(dogAnimal1);
//
//
        Dog dog = new Dog();
        AnimalActivity.eat(dog);
    }
}
