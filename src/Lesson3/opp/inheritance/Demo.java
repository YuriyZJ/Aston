package  Lesson3.opp.inheritance;


import  Lesson3.opp.inheritance.phone.AbstractPhone;
import  Lesson3.opp.inheritance.phone.CellPhone;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        AbstractPhone mts = new CellPhone(2012, 4);
        mts.call(464);
    }
}
