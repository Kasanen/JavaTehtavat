import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the size of the array: ");
            int size = scanner.nextInt();
            System.out.println("Enter the integers into the array: ");

            int[] numbers = new int[size];

            // Kysytään käyttäjältä numero kerrallaan
            for (int i = 0; i < size; i++) {
                System.out.println("Enter integer " + (i + 1) + ":");
                numbers[i] = scanner.nextInt();
            }

            int maxSum = 0;
            int startIndex = 0;
            int endIndex = 0;

            // Outer loop
            // Size toimii indexinä
            for (int start = 0; start < size; start++) {
                int sum = 0;
                // Inner loop
                for (int end = start; end < size; end++) {
                    sum += numbers[end];

                    if (sum > maxSum) {
                        maxSum = sum;
                        startIndex = start;
                        endIndex = end;
                    }
                }
            }

            // Output
            System.out.println("\nMaximum sum: " + maxSum);
            System.out.println("Integers: " + (startIndex + 1) + "-" + (endIndex + 1));
        }
    }
}
