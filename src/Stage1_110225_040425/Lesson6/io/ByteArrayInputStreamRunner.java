package Stage1_110225_040425.Lesson6.io;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamRunner {
    public static void main(String[] args) {
        readAllBytes();
        System.out.println("---------------------");
        readFiveChars();

    }

    private static void readAllBytes() {
        byte[] array = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteStream = new ByteArrayInputStream(array);
        int b;
        while ((b = byteStream.read()) != -1) {
            System.out.println(b);
        }
    }

    private static void readFiveChars() {
        String value = "Hello Java!";
        byte[] array = value.getBytes();

        //считываем 5 символов
        ByteArrayInputStream byteStream = new ByteArrayInputStream(array, 7, 5);
        int c;
        while ((c = byteStream.read()) != -1) {
            System.out.println((char) c);
        }
    }
}
