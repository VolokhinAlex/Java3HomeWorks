package homework4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        WorkWithWaitAndNotify work = new WorkWithWaitAndNotify();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> work.printChar('A', 'B', 5));
        executorService.submit(() -> work.printChar('B', 'C', 5));
        executorService.submit(() -> work.printChar('C', 'A', 5));
        executorService.shutdown();
    }
}
