package Stage1_110225_040425.Lesson2.abstractclass;

class Student extends Person {
    private final String universityName;

    public Student(String name, String universityName) {
        super(name);
        this.universityName = universityName;
    }

    public Student(String name) {
        super(name);
        this.universityName = "СПБУ";
    }

    @Override
    public void display(){
        System.out.printf("Student Name: %s \t University: %s \n", super.getName(), universityName);
    }
}
