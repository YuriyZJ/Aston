package  Stage1_110225_040425.Lesson3.objects;

public class Main {


    public static void main(String[] args) {
        System.out.println("----------------programmer1-----------------------");
        Programmer programmer1 = new Programmer(1, "Junior", 300);
        System.out.println("hashcode = " + programmer1.hashCode());
        System.out.println("toString = " + programmer1);
        System.out.println("----------------programmer2-----------------------");
        Programmer programmer2 = new Programmer(2, "Junior", 300);
        System.out.println("hashcode = " + programmer2.hashCode());
        System.out.println("toString  = " + programmer2);
        //false
        System.out.println("compare heap links " + (programmer1 == programmer2));
        //true
        System.out.println("Checking equality between programmer1 and programmer2 = " + programmer1.equals(programmer2));
        System.out.println("----------------programmer3-----------------------");
        Programmer programmer3 = new Programmer(3, "Middle", 300);
        System.out.println("hashcode = " + programmer3.hashCode());
        System.out.println("toString  = " + programmer3);
        //false
        System.out.println("compare heap links " + (programmer1 == programmer3));
        //false
        System.out.println("Checking equality between programmer1 and programmer3 = " + programmer1.equals(programmer3));

        System.out.println("----------------programmer4-----------------------");
        Programmer programmer4 = Programmer.createProgrammer(programmer1);
        System.out.println("compare heap links " + (programmer1 == programmer4));
        System.out.println("hashcode = " + programmer4.hashCode());
        System.out.println("toString  = " + programmer4);
        //false
        System.out.println("Checking equality between programmer1 and programmer4 = " + programmer1.equals(programmer4));
        System.out.println("----------------programmer5-----------------------");
        Programmer programmer5 = new Programmer(5, "Junior", 250);
        //false
        System.out.println("compare heap links " + (programmer1 == programmer5));
        System.out.println("hashcode = " + programmer5.hashCode());
        System.out.println("toString  = " + programmer5);
        //true
        System.out.println("Checking equality between programmer1 and programmer5 = " + programmer1.equals(programmer5));


    }
}