package Lesson6.Homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

public class Replacement {

    public void toReplacement() throws IOException {
        Path path = Paths.get("src/Lesson6/Homework/Concatenation.txt");
        Path replacementPath = Paths.get("src/Lesson6/Homework/Replacement");

        if (!Files.exists(path)) {
            System.out.println("File does not exist");
        }

        List<String> lines = Files.readAllLines(path).stream()
                .map(line -> line.replaceAll("[^a-zA-Z0-9]", "$"))
                .collect(Collectors.toList());

        Files.write(replacementPath, lines);
        System.out.println("File written");
    }
}
