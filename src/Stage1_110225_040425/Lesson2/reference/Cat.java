package Stage1_110225_040425.Lesson2.reference;

public class Cat {
    public static String type = "CAT";
    private int weight;
    protected String name;

    public static void print() {
        System.out.println("Print cat");
    }

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    void eating(Food food) {
        System.out.println("I am eating " + food.name);
    }

    String sing() {
        return "mayu";
    }

}
