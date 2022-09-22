package homework5;

import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static boolean isWin;
    private static final AtomicInteger position = new AtomicInteger();

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

        MainClass.winLock.lock();
        if (!isWin) {
            System.out.printf("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> %s победил в гонке!!!\n", name);
            position.incrementAndGet();
            isWin = true;
        } else {
            System.out.printf("%s закончил гонку и занял %d место!\n", name, position.incrementAndGet());
        }
        MainClass.winLock.unlock();
        MainClass.phaser.arriveAndDeregister();
    }

}
