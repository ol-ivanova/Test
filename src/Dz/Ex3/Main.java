package Dz.Ex3;

public class Main {
    public static <T> T lastElement(T[] array) {
        return array[array.length - 3];
    }

    /**Java обобщения (generics) работают только с объектами (Integer, String и т.д.)., а не с примитивами (int, double, char и т.д.).
     */
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4};
        System.out.println(lastElement(ints));
    }
}
