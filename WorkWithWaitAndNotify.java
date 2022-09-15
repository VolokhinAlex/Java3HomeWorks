package homework4;

public class WorkWithWaitAndNotify {

    private final char CHAR_A = 'A';
    private final char CHAR_B = 'B';
    private final char CHAR_C = 'C';
    private volatile char currentChar = 'A';

    public synchronized void printCharA(int count) {
        try {
            for (int i = 0; i < count; i++) {
                while (currentChar != CHAR_A) {
                    wait();
                }
                System.out.print(CHAR_A);
                currentChar = CHAR_B;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printCharB(int count) {
        try {
            for (int i = 0; i < count; i++) {
                while (currentChar != CHAR_B) {
                    wait();
                }
                System.out.print(CHAR_B);
                currentChar = CHAR_C;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printCharC(int count) {
        try {
            for (int i = 0; i < count; i++) {
                while (currentChar != CHAR_C) {
                    wait();
                }
                System.out.print(CHAR_C);
                currentChar = CHAR_A;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
