package  Lesson3.opp.encapsulation;

public class SomePhone {

    private int year;
    private String company;
    public SomePhone(int year, String company) {
        this.year = year;
        this.company = company;
    }
    private void openConnection(){
        //findComutator
        //openNewConnection...
    }
    private void newOpenConnection(){
        //findComutator
        //openNewConnection...
    }

    public void call() {
        newOpenConnection();
        System.out.println("Вызываю номер");
    }

    public void ring() {
        System.out.println("Дзынь-дзынь");
    }
}
