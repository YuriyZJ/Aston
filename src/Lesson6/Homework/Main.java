package Lesson6.Homework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Write write = new Write();
        try {
            write.toWrite("Task");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Read read = new Read();
        try {
            read.readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Concatenation concatenation = new Concatenation();
        try {
            concatenation.toConcatenation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Replacement replacement = new Replacement();
        try {
            replacement.toReplacement();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
