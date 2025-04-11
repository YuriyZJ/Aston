package  Stage1_110225_040425.Lesson3.opp.inheritance.phone;


public abstract class WirelessPhone extends AbstractPhone {

    private int hour;

    public WirelessPhone(int year, int hour) {
        super(year);
        this.hour = hour;
    }
}
