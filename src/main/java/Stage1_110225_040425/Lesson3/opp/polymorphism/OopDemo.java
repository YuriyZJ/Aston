package Stage1_110225_040425.Lesson3.opp.polymorphism;


import  Stage1_110225_040425.Lesson3.opp.inheritance.phone.AbstractPhone;
import  Stage1_110225_040425.Lesson3.opp.inheritance.phone.CellPhone;
import  Stage1_110225_040425.Lesson3.opp.inheritance.phone.Smartphone;
import  Stage1_110225_040425.Lesson3.opp.inheritance.phone.VideoPhone;

public class OopDemo {
    public static void main(String[] args) {
        AbstractPhone phone = new CellPhone(1984, 4);
        AbstractPhone smartphone = new Smartphone(2018, 4, "MTS");
        AbstractPhone videoPhone = new VideoPhone(2018);
        User user = new User("Андрей");
        user.callAnotherUser(224466, phone);
        user.callAnotherUser(224466, smartphone);
        user.callAnotherUser(224466, videoPhone);
    }
}
