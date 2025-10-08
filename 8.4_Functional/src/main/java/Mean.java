import java.util.Arrays;
import java.util.List;

public class Mean {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        double mean = (double) sum / numbers.size();
        System.out.println(mean);
    }
}