import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter binary numbers: ");

        String binary = scanner.nextLine();

        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Decimal value: " + decimal);

        scanner.close();
    }
}
