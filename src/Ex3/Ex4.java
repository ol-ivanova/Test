package Ex3;

public class Ex4 implements Storage<Integer>{

    int a;

    @Override
    public void store(Integer item) {
        a = item;
    }

    @Override
    public Integer retrieve() {
        return a;
    }

    public static void main(String[] args) {
        Ex4 a = new Ex4();
        a.store(4);
        System.out.println(a.retrieve());

    }
}
