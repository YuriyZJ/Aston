package Stage1_110225_040425.Lesson3.opp.inheritance.phone;


public class VideoPhone extends AbstractPhone {

    public VideoPhone(int year) {
        super(year);
    }

    @Override
    public void call(int outputNumber) {
        System.out.println("Подключаю видеоканал для абонента " + outputNumber);
    }

    @Override
    public void ring(int inputNumber) {
        System.out.println("У вас входящий видеовызов..." + inputNumber);
    }
}
