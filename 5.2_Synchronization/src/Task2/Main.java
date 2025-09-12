
import java.util.ArrayList;
import java.util.List;

class Words extends Thread {

    private SafeList<String> safeList;
    private String word;

    public Words(SafeList<String> safeList, String word) {
        this.safeList = safeList;
        this.word = word;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " adding: " + word);
        safeList.add(word);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " removing: " + word);
        safeList.remove(word);
    }
}

public class Main {

    public static void main(String[] args) {
        SafeList<String> safeList = new SafeList<>();
        List<Words> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Words w = new Words(safeList, "Word" + i);
            threads.add(w);
            w.start();
        }

        for (Words w : threads) {
            try {
                w.join();
            } catch (InterruptedException e) {
            }
        }
    }
}
