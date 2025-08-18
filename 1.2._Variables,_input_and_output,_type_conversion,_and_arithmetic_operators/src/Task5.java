import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Import Fahrenheit");

        int intValue = Integer.parseInt(scanner.nextLine());
        double fahrenheit = intValue;
        double celsius = (fahrenheit - 32) * 5 / 9;

        System.out.println("Celsius: " + celsius);
    }
}
