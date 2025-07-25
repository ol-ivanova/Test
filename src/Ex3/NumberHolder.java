package Ex3;

import java.util.List;

public class NumberHolder<T extends Number> {
    private T t;

    public NumberHolder(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        NumberHolder<Integer> numberHolder = new NumberHolder<>(4);
    }
}
