package Stage1_110225_040425.Lesson2.abstractclass;

import java.util.ArrayList;

public class ProgramDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        Employer sam = new Employer("Sam", "Leman Brothers");
        //sam.display();
        Student bob = new Student("Bob", "UFO");
       // bob.display();

        Employer personSam = new Employer("Sam", "Leman Brothers");
        //personSam.display();
        Person personBob = new Student("Bob", "MGU");
        ArrayList<Person> employers = new ArrayList<>();
        employers.add(sam);
        employers.add(personSam);
        employers.add(personBob);

        for (Person employer: employers){
            System.out.println(employer.toString());
        }
        //personBob.display();

    }
}


