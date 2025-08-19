import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the size of the array: ");
            int size = scanner.nextInt();
            System.out.println("Enter the integers into the array: ");

            int[] numbers = new int[size];
            int[] finish = new int[size];
            int finishIndex = 0;

            // Kysytään käyttäjältä numero kerrallaan
            for (int i = 0; i < size; i++) {
                System.out.println("Enter integer " + (i + 1) + ":");
                numbers[i] = scanner.nextInt();
            }

            for (int j = 0; j < size; j++) {
                boolean uniikki = true;

                for (int k = 0; k < finishIndex; k++){
                    if (numbers[k] == numbers[j]){
                        uniikki = false;
                        break;
                    }
                }
                if (uniikki) {
                    finish[finishIndex] = numbers[j];
                    finishIndex++;
                }
            }

            // Output
            System.out.println("\nThe array without duplicates: ");
            for (int i = 0; i < finishIndex; i++) {
                System.out.print(finish[i] + " ");
            }
            System.out.println();
        }
    }
}
