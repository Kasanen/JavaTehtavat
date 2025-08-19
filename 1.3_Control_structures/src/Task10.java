import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give 2 positive integers: ");
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        while (a <= b) {
            if (a > 1) {
                int i = 2;
                boolean isPrime = true;

                while (i <= Math.sqrt(a)) {
                    if (a % i == 0) {
                        isPrime = false;
                        break;
                    }
                    i++;
                }
                if (isPrime) {
                    System.out.println(a);
                }
            }
            a++;
        }
        scanner.close();
    }
}
