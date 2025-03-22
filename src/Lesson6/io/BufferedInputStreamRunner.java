package Lesson6.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
public class BufferedInputStreamRunner {
    public static void main(String[] args) {

        String text = "Hello Java";
        byte [] buffer = text.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buffer);

        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            int c;
            while ((c = bis.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
    }
}
