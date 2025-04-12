package Stage1_110225_040425.Lesson4.Task1;

import java.util.HashMap;
import java.util.List;

public class HachMapMethods {
    public static void main(String[] args) {
        HashMap<Integer, String> hachMap = new HashMap<>();

        hachMap.put(1, "Java");
        hachMap.put(2, "Python");
        hachMap.put(3, "C++");
        hachMap.put(4, "C#");
        hachMap.put(5, "PHP");

        hachMap.remove(4);
        // hachMap.clear();
        hachMap.keySet().removeAll(List.of(2, 3));

        System.out.println(hachMap);

    }
}
