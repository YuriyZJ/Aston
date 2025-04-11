package  Stage1_110225_040425.Lesson3.opp.inheritance.phone;

public class Smartphone extends CellPhone {

    private String operationSystem;

    public Smartphone(int year, int hour, String operationSystem) {
        super(year, hour);
        this.operationSystem = operationSystem;
    }

    @Override
    public void call(int outputNumber) {
        System.out.println("Вызываю номер со смартфона " + outputNumber);;
    }

    @Override
    public void ring(int inputNumber) {
        super.ring(inputNumber);
    }

    public void install(String program){
        System.out.println("Устанавливаю " + program + "для" + operationSystem);
    }

    public void install(Long programId){
        System.out.println("Устанавливаю программу с id " + programId + "для" + operationSystem);
    }

}
