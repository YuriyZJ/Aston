package Stage1_110225_040425.Lesson3.opp.inheritance;


import  Stage1_110225_040425.Lesson3.opp.inheritance.phone.AbstractPhone;
import  Stage1_110225_040425.Lesson3.opp.inheritance.phone.CellPhone;

public class Demo {
    public static void main(String[] args) {
        AbstractPhone mts = new CellPhone(2012, 4);
        mts.call(464);
    }
}
