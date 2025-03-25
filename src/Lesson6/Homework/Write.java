package Lesson6.Homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Write {

    public void toWrite(String text) throws IOException {
        Path path = Paths.get("src/Lesson6/Homework/Example.txt");
        Files.write(path, text.getBytes());
        System.out.println("File to write");
    }
}
