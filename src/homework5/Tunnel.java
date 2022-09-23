package homework5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore maxCountCarsInTunnel;

    public Tunnel(Semaphore maxCountCarsInTunnel) {
        this.maxCountCarsInTunnel = maxCountCarsInTunnel;
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
            maxCountCarsInTunnel.acquire();
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(car.getName() + " закончил этап: " + description);
            maxCountCarsInTunnel.release();
        }
    }
}
