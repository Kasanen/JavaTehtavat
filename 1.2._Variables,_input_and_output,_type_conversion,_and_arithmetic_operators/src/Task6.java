import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Import length of legs of the triangle");
        int intValue1 = Integer.parseInt(scanner.nextLine());
        int intValue2 = Integer.parseInt(scanner.nextLine());

        double hypotenuse = Math.sqrt(intValue1 * intValue1 + intValue2 * intValue2);
        System.out.println("Hypotenuse: " + hypotenuse);
    }
}
