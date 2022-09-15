package homework4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        WorkWithWaitAndNotify work = new WorkWithWaitAndNotify();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> work.printCharA(5));
        executorService.submit(() -> work.printCharB(5));
        executorService.submit(() -> work.printCharC(5));
        executorService.shutdown();
        // A B C | A B C | A B C | A B C | A B C
    }


}
