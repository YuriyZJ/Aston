package Stage1_110225_040425.Lesson6.Homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Read {

    public void readFile() throws IOException {
        Path path = Paths.get("src/Stage1_110225_040425.Lesson6/Homework/Example.txt");
        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);
    }
}
