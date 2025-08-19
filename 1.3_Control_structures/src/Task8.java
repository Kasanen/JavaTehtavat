import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coefficient a: ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter coefficient b: ");
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter coefficient c: ");
        int c = Integer.parseInt(scanner.nextLine());

        int discriminant = b*b - 4 * a * c;
        
        if (a ==0) {
            System.err.println("a cannot be 0!");
        }
        else if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2*a);
            System.out.println("Two real roots: " + root1 + " and " + root2);
        }
        else if (discriminant == 0) {
            double root = -b / (2*a);
            System.out.println("One real root: " + root);
        }
        else {
            System.out.println("No real roots");
        }
    }
}
