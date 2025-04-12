package Stage1_110225_040425.Lesson6.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamRunner {
    public static void main(String[] args) {

        String text = "Hello Java!"; //строка для записи

        try (FileOutputStream outputStream = new FileOutputStream("files/text4.txt")) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            byte[] buffer = text.getBytes();
            bufferedOutputStream.write(buffer, 0, buffer.length);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
