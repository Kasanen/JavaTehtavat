
public class MultiThread extends Thread {

    private String whatToSay;
    private boolean printEven;
    private int amount;

    public MultiThread(String whatToSay, boolean printEven) {
        this.whatToSay = whatToSay;
        this.printEven = printEven;
        this.amount = 20;
    }

    public void run() {
        try {
            int i = 1;
            while (i <= amount) {
                if (printEven && i % 2 == 0) {
                    System.out.println(whatToSay + i);
                } else if (!printEven && i % 2 != 0) {
                    System.out.println(whatToSay + i);
                }
                i++;
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void main(String[] args) {
        MultiThread evenThread = new MultiThread("Even Thread: ", true);
        MultiThread oddThread = new MultiThread("Odd Thread: ", false);
        
        evenThread.start();
        oddThread.start();

        // Waiting for threads to finish
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
        
        }

        System.out.println("Printing complete.");
    }
}
