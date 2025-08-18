import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Weight (g): ");
            int intValue = Integer.parseInt(scanner.nextLine());

            double luoti = intValue / 13.28;
            int leiviskaKoko = (int) (luoti / 640);
            
            double luotiJaljella = luoti - (leiviskaKoko * 640);
            
            int naulaKoko = (int) (luotiJaljella / 32);
            double luotiLoppu = luotiJaljella - (naulaKoko * 32);

            System.out.println(intValue + " grams is " + leiviskaKoko + " leiviskä, " + naulaKoko + " naula, " + String.format("%.2f", luotiLoppu) + " luoti.");
        }
    }
}
