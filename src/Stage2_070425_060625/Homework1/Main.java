package Stage2_070425_060625.Homework1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(8, "eight");
        map.put(10, "ten");
        map.put(17, "seventeen");
        map.put(1, "eleven");
        map.print();
        System.out.println();

        System.out.println(map.get(1));
        map.remove(2);
        map.replace(3, "three", "!!!!!!!" );
        map.print();


        //Fitch, сделал для чтения файлов Java и вывел их в отдельный файл)
        Concatenation concat = new Concatenation();
        concat.toConcatenation();
    }
}
