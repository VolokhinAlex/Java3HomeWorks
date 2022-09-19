package homework4;

public class WorkWithWaitAndNotify {
    private volatile char currentChar = 'A';

    public synchronized void printChar(char lastChat, char nextChar, int count) {
        try {
            for (int i = 0; i < count; i++) {
                while (currentChar != lastChat) {
                    wait();
                }
                System.out.print(lastChat);
                this.currentChar = nextChar;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
