package Stage1_110225_040425.Lesson2.abstractclass;


public class Employer extends Person {
    public String company;

    public Employer(String name, String company) {
        super(name);
        this.company = company;
    }

    @Override
    public void display() {
        System.out.printf("Employee Name: %s \t Bank: %s \n", super.getName(), company);
    }


}
