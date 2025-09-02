
public class BankAccount {

    private int balance;
    private int accountNumb;
    private static int nextAccountNumber = 1;
    private static int totalAccounts = 0;

    public BankAccount(int balance) {
        this.balance = balance;
        this.accountNumb = nextAccountNumber++;
        totalAccounts++;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("Added " + amount + " to account");
    }

    public void withdraw(int amount) {
        this.balance -= amount;
        System.out.println("Decreased " + amount + " from account");
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumb;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
