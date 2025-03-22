package Lesson6.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("files", "text3.txt");

        Files.lines(path)
                .forEach(System.out::println);

        System.out.println("-------------------------");

        List<String> strings = Files.readAllLines(path);
        strings.forEach(System.out::println);
    }
}
