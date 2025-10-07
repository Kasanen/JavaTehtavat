
import java.util.*;

interface Summary {

    int add(int a, int b);
}

public class NumberList {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));

        integers.removeIf(n -> n % 2 == 0);
        System.out.println(integers);

        integers.replaceAll(n -> n * 2);
        System.out.println(integers);

        int total = 0;
        Summary sum = (a, b) -> (a + b);
        for (int number : integers) {
            total = sum.add(total, number);
        }
        System.out.println(total);
    }
}
