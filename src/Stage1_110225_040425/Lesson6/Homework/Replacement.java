package Stage1_110225_040425.Lesson6.Homework;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

public class Replacement {

    public void toReplacement() throws IOException {
        Path path = Paths.get("src/Stage1_110225_040425.Lesson6/Homework/Concatenation.txt");
        Path replacementPath = Paths.get("src/Stage1_110225_040425.Lesson6/Homework/Replacement.txt");

        if (!Files.exists(path)) {
            System.out.println("File does not exist");
            return;
        }

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8).stream()
                .map(line -> line.replaceAll("[^а-яА-Яa-zA-Z0-9]", "\\$"))
                .collect(Collectors.toList());

        Files.write(replacementPath, lines, StandardCharsets.UTF_8);
        System.out.println("File written");
    }
}
