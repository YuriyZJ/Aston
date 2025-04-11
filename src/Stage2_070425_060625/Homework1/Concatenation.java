package Stage2_070425_060625.Homework1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Concatenation {

    public void toConcatenation() throws IOException {
        Path path1 = Paths.get("src/Level2/Chapter3/Task4/Main.java");
        Path path2 = Paths.get("src/Level2/Chapter3/Task4/MyHashMap.java");
        Path outputPath = Paths.get("src/Level2/Chapter3/Task4/Concatenation.txt");

        if (!Files.exists(path1) && !Files.exists(path2)) {
            System.out.println("Files not found");
        }

        byte[] line1 = Files.readAllBytes(path1);
        byte[] line2 = Files.readAllBytes(path2);

        Files.write(outputPath, line1);
        Files.write(outputPath, List.of(System.lineSeparator()), StandardOpenOption.APPEND);
        Files.write(outputPath, line2, StandardOpenOption.APPEND);
        System.out.println("Concatenation finished");

    }
}
