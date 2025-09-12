import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Theater {
    private int availableSeats;
    private int amount;

    public Theater(int totalSeats, int maxTickets) {
        this.availableSeats = totalSeats;
        this.amount = maxTickets;
    }

    public synchronized boolean reserveSeat(String customerName, int amount) {
        if (availableSeats >= amount) {
            availableSeats -= amount;
            System.out.println(customerName + " reserved " + amount + " tickets.");
            return true;
        } else {
            System.out.println(customerName + " couldn't reserve " + amount + " tickets.");
            return false;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getTicketAmount() {
        return amount;
    }
}

class Customer extends Thread {
    private Theater theater;
    private String customerName;
    private int amount;

    public Customer(Theater theater, String customerName, int amount) {
        this.theater = theater;
        this.customerName = customerName;
        this.amount = amount;
    }

    public void run() {
        theater.reserveSeat(customerName, amount);
    }
}

public class Main {
    public static void main(String[] args) {
        int maxTickets = 4;
        int totalSeats = 10;
        int customerCount = 15;

        Theater theater = new Theater(totalSeats, maxTickets);
        List<Customer> customers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= customerCount; i++) {
            int amount = rand.nextInt(maxTickets) + 1;
            Customer customer = new Customer(theater, "Customer " + i, amount);
            customers.add(customer);
            customer.start();
        }

        for (Customer customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}