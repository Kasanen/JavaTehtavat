public class Calculator {

    private int value;

    public Calculator() {
        value = 0;
    }

    public void reset() {
        value = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed.");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }

    // Write method signature
    public int sum(int[] numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    // Write method signature and first line
    public int sumWithWhile(int[] numbers) {
        int total = 0;
        int i = 0;
        while (i < numbers.length) {
            total += numbers[i];
            i++;
        }
        return total;
    }

    // Write a comment describing the method
    // Sums all integers in the array using a traditional for loop.
    public int sumWithFor(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(5);
        System.out.println(calc.getValue()); // 5
        calc.reset();
        System.out.println(calc.getValue()); // 0

        // Demonstrate sum methods
        int[] nums = {2, 4, 6, 8};
        System.out.println("Sum (for-each): " + calc.sum(nums));
        System.out.println("Sum (while): " + calc.sumWithWhile(nums));
        System.out.println("Sum (for): " + calc.sumWithFor(nums));
    }
}