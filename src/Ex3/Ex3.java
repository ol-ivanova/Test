package Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex3 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(List.of(5, 6, 7, 8));
        System.out.println(mergeLists(list1, list2));

        List<String> list3 = new ArrayList<>(List.of("A", "D"));
        List<String> list4 = new ArrayList<>(List.of("C", "V"));
        System.out.println(mergeLists(list3, list4));

    }

    public static <T> List<T> mergeLists(List<T> list1, List<T> list2){
        List<T> list3 = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
        return list3;
    }

}
