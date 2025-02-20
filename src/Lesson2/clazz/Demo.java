package Lesson2.clazz;



import Lesson2.abstractclass.Employer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {
        Employer employer = new Employer("Fill", "Aston");
        Class<? extends Employer> aClass = employer.getClass();
        Class<?> employerClass = Class.forName(" abstractclass.Employer");
        Field[] fields = employerClass.getFields();
        Method[] methods = employerClass.getMethods();

    }
}