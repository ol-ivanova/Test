package Ex3;

import java.util.List;
import java.util.function.Predicate;

public class Ex5 {
    public static <T> T findFirst(List<T> list, Predicate<T> predicate){
        for(T str: list){
            if(predicate.test(str)){
                return str;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Integer findFirst = findFirst(numbers, n -> n%2 == 0 );
        Integer a = findFirst(numbers, n-> n > 5);
        System.out.println(a);
    }
}
