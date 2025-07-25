package Dz.Ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        printList(list);

    }
    public static void printList(List<? extends Number> list) {
        for (Number a : list) {
            System.out.println(a);
        }
    }
}


