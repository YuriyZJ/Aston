package Stage1_110225_040425.Lesson2.interfaces;

class Journal implements Printable {

    private String name;

    String getName() {
        return name;
    }

    Journal(String name) {

        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name);
    }
}