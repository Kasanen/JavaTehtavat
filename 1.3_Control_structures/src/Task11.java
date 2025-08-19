import java.util.Random;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Multiplication table exam!");
        int kerrat = 1;

        while (kerrat <= 10) {
            int a = rand.nextInt(10);
            int b = rand.nextInt(10);

            System.out.println(a + " * " + b);
            int perfect = a*b;
            int answer = Integer.parseInt(scanner.nextLine());
            System.out.println("Answer is: " + answer);
            
            if (answer != perfect){
                System.out.println("Wrong answer!");
                kerrat = 0;
            }
            else {
                System.out.println("Answer is right.");
            }

            System.out.println("Points: " + kerrat);
            kerrat++;
        }
        System.out.println("Congratulations for mastering the multiplication tables and terminates!");
        scanner.close();
    }
}
