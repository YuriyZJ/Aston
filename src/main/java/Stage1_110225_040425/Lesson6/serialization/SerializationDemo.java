package Stage1_110225_040425.Lesson6.serialization;

import Stage1_110225_040425.Lesson6.serialization.first.Person;

import java.io.*;
import java.nio.file.Path;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("files", "person.out");

//        writeObject(path);
        readObject(path);
    }

    private static void readObject(Path path) throws IOException, ClassNotFoundException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Person object = (Person) objectInputStream.readObject();
            System.out.println(object);
        }
    }

    private static void writeObject(Path path) throws IOException {
        Person object = new Person(30, "Bob", "Jonson");
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream((path.toFile())))) {
            objectOutputStream.writeObject(object);
        }
    }
}
