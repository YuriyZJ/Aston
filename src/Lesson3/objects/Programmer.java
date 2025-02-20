package  Lesson3.objects;

import java.util.Objects;

public class Programmer {

    private final int id;
    private final String position;
    private final Integer salary;

    public Programmer(int id, String position, int salary) {
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    public Programmer(Programmer programmer) {
        this.id = programmer.id;
        this.position = programmer.position;
        this.salary = programmer.salary;
    }

    public static Programmer createProgrammer(Programmer programmer) {
        return new Programmer(programmer.id, programmer.position, programmer.salary);
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }


//    @Override
//    public int hashCode() {
//        return id;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) return false;
//        if (!(obj instanceof Programmer))
//            return false;
//        if (obj == this)
//            return true;
//        return this.getPosition() == ((Programmer) obj).getPosition();
//    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Programmer other)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean positionEquals = (this.position == null && other.position == null)
                                 || (this.position != null && this.position.equals(other.position));
        boolean salaryEquals = (Objects.equals(this.salary, other.salary));
        boolean idEquals = (this.id == other.id);

        return positionEquals && salaryEquals && idEquals;
    }

    @Override
    public int hashCode() {
        int result =  position != null ? position.hashCode() : 0;
        int i = Objects.nonNull(salary) ? salary.hashCode() : 0;
        result = 32 * result + i;
        result = 31 * result + id;
        return result;
    }

}
