package Dz.Ex1;

import java.util.HashMap;
import java.util.Map;

public class Main implements Pair <String, Integer> {
    Map<Integer, String> map = new HashMap<>();

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public Integer getValue() {
        return 0;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Понедельник", 1);
        map1.put("Вторник", 2);
        map1.put("Среда", 3);
        map1.put("Четверг", 4);


    }
}
