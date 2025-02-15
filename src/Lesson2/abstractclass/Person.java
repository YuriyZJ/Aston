package Lesson2.abstractclass;
 abstract class Person {

    private String name;

    public String getName() {
        return name; }

    public Person(String name){
        this.name=name;
    }

     @Override
     public String toString() {
         return "Person{" +
                 "name='" + name + '\'' +
                 '}';
     }

     public abstract void display();

}
