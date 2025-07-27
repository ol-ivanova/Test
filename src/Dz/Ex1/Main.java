package Dz.Ex1;

import java.util.HashMap;
import java.util.Map;

public class Main implements Pair <String, Integer> {
    Map.Entry<String, Integer> entry;

    @Override
    public String getKey() {
        return entry.getKey();
    }

    @Override
    public Integer getValue() {
        return entry.getValue();
    }

    public Main(Map.Entry<String, Integer> entry) {
        this.entry = entry;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry1 : map.entrySet()){
            Main main = new Main(entry1);
            System.out.println(main.getKey());
            System.out.println(main.getValue());
        }
    }
}
