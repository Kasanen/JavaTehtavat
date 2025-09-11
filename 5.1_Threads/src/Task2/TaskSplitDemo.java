
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskSplitDemo {

    private static final int N = 100000;

    // The chunk work for each core
    static class SumWorker extends Thread {

        private List<Integer> chunk;
        private int partialSum = 0;

        public SumWorker(List<Integer> chunk) {
            this.chunk = chunk;
        }

        public void run() {
            for (int num : chunk) {
                partialSum += num;
            }
        }

        public int getPartialSum() {
            return partialSum;
        }
    }

    public static void execute(int cores) {
        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = rand.nextInt();
            numbers.add(num);
        }

        int chunkSize = N / cores;
        List<SumWorker> workers = new ArrayList<>();

        // Splitting chunks per core
        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = (i == cores - 1) ? N : start + chunkSize;
            List<Integer> chunk = numbers.subList(start, end);
            SumWorker worker = new SumWorker(chunk);
            workers.add(worker);
            worker.start();
        }

        // Summing every core chunk
        int totalSum = 0;
        for (SumWorker worker : workers) {
            try {
                worker.join();
                totalSum += worker.getPartialSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total sum: " + totalSum);
    }

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Our system has " + cores + " processor cores\n");
        System.out.print(cores + " Thread(s): ");
        execute(cores);
    }
}
