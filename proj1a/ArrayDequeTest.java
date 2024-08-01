
public class ArrayDequeTest {

    public static void randomAddSizeTests(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        ad1.addLast(0);
        ad1.addFirst(1);
        ad1.addLast(2);
        ad1.addLast(3);

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        randomAddSizeTests();
    }
}
