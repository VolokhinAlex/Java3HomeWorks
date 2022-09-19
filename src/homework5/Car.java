package homework5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    public static boolean isWin;
    private Lock winLock = new ReentrantLock();

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        isWin = false;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(name + " готов");
            MainClass.phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        winLock.lock();
        if (!isWin) {
            System.out.printf("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> %s победил в гонке!!!\n", name);
            isWin = true;
            winLock.unlock();
        } else {
            System.out.printf("%s закончил гонку!\n", name);
        }

        MainClass.phaser.arriveAndDeregister();
    }

}
