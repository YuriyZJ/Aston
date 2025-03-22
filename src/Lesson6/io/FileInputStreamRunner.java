package Lesson6.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamRunner {
    public static void main(String[] args) {

        readEachFile();
        System.out.println("----------------------------");
        readAllBytes();

    }

    private static void readEachFile() {
        try(FileInputStream inputStream = new FileInputStream("files/text.txt")) {

            byte[] bytes = new byte[inputStream.available()]; //Получаем размер потока
            int counter = 0;
            byte currentByte;

            while ((currentByte = (byte) inputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String stringValue = new String(bytes);
            System.out.println(stringValue);
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void readAllBytes() {
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream("files/text.txt");
            byte[] bytes = inputStream.readAllBytes();
            String stringValue = new String(bytes);
            System.out.println(stringValue);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
