import java.util.Random;
import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("How many names the program should generate?");
        int maara = Integer.parseInt(scanner.nextLine());
        int kerrat = 1;

        String[] firstNames = {
            "Alice", "Bob", "Charlie", "Diana", "Ethan",
            "Fiona", "George", "Hannah", "Isaac", "Julia",
            "Kevin", "Luna", "Michael", "Nora", "Oliver",
            "Paula", "Quinn", "Ryan", "Sophia", "Thomas",
            "Uma", "Victor", "Wendy", "Xavier", "Yara", "Zane"
        };

        String[] lastNames = {
            "Smith", "Johnson", "Brown", "Taylor", "Anderson",
            "Thomas", "Jackson", "White", "Harris", "Martin",
            "Thompson", "Garcia", "Martinez", "Robinson", "Clark",
            "Rodriguez", "Lewis", "Lee", "Walker", "Hall",
            "Allen", "Young", "King", "Wright", "Scott", "Green"
        };

        while (kerrat <= maara) {
            int index1 = rand.nextInt(25);
            int index2 = rand.nextInt(25);

            System.out.println(firstNames[index1] + " " + lastNames[index2]);
            kerrat++;
        }
        scanner.close();
    }
}
