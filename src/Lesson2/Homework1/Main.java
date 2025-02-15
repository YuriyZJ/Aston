package Lesson2.Homework1;

public class Main {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("Aircraft");
        Helicopter helicopter = new Helicopter("Helicopter");
        Speedboat speedboat = new Speedboat("Speedboat");
        Tanker tanker = new Tanker("Tanker");
        Track track = new Track("Track");
        Taxi taxi = new Taxi("Taxi");

        aircraft.move();
        aircraft.cargo();
        aircraft.screw();
        aircraft.wheel();
        aircraft.wing();
    }
}
