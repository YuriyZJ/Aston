package Lesson6.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamRunner {
    public static void main(String[] args) throws IOException {

        try(FileOutputStream outputStream = new FileOutputStream("files/text4.txt", true)) {
            String value = "Hello Java";
            outputStream.write(value.getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }
}
