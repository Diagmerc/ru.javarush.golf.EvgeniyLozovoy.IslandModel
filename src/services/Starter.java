package services;
import island.Island;
import parameters.Parameters;

import java.util.concurrent.*;

public class Starter implements Runnable {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
    int workTimer;

    public Starter() {
        this.workTimer = new Parameters().getWorkTimer();
    }

    public void timer(int sec){
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Island island = new Island();
        island.initialize();
        executor.scheduleAtFixedRate(island, 1, 2, TimeUnit.SECONDS);
        timer(workTimer);
        System.out.println("Game over");
            island.printStatistic();


    }

}
