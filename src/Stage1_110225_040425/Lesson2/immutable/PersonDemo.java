package Stage1_110225_040425.Lesson2.immutable;

import java.util.ArrayList;

public class PersonDemo {
    public static void main(String[] args) {
        ArrayList<String> preferFilmsFirst = new ArrayList<>();
        preferFilmsFirst.add("Avatar");

        Person ivan = new Person("Ivan", 30, preferFilmsFirst);
        System.out.println(ivan);

        preferFilmsFirst.add("Avatar 2");
        Person liza = new Person("Liza", 28, preferFilmsFirst);
        System.out.println(liza);
        System.out.println(ivan);
//
//        runtime exception
//        List<String> preferFilms = ivan.getPreferFilms();
//
//        System.out.println(preferFilms);
//        preferFilms.add("ADF");
    }


}
