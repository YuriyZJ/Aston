package Stage1_110225_040425.Lesson6.rw;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderRunner {
    public static void main(String[] args) {
        readFileBeEachChar();

    }

    private static void readFileBeEachChar() {
        try(FileReader reader = new FileReader("files/text3.txt")) {
            //читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
