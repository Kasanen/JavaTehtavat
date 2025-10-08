
import java.util.Arrays;
import java.util.List;

public class NumbersList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        System.out.println(numbers.stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(x -> x * 2 )
                .sum()
        );
    }
}
