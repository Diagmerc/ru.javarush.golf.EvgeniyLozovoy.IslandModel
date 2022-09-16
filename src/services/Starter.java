package services;
import island.Island;
import island.Location;
import parameters.Parameters;
import java.util.concurrent.*;

public class Starter {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
    int workTimer;
    Island island = new Island();

    public Starter() {
        this.workTimer = new Parameters().getWorkTimer();
    }
    public void init() {
        island.initialize();
        island.printStatistic();
            for (Location[] location : Island.locations) {
                for (Location value : location) {
                    System.out.println(value);
                    executor.scheduleAtFixedRate(value, 1, 2, TimeUnit.SECONDS);
                }
            }
    }
    public void go(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
        scheduledThreadPool.scheduleWithFixedDelay(this::init, 1,2,TimeUnit.SECONDS);
        try {
            executor.awaitTermination(workTimer, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        scheduledThreadPool.shutdown();
        island.printStatistic();
        System.out.println("Game over");
    }
}
