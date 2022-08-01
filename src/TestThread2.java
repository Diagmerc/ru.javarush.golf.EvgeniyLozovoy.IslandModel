import Animals.Animal;
import Island.Island;

import java.util.List;

public class TestThread2 implements Runnable {
    @Override
    public void run() {
        Island island = new Island();
        island.initialize();
        for(int i = 0; i >= Island.locations.length / 2;i++)
        {
            for (int j = 0; j < Island.locations[i].length; j++) {
                List<Animal> animals = Island.locations[i][j].getAnimals();
                for (int k = 0; k < animals.size(); k++) {
                    if (animals.get(k) != null) {
                        animals.get(k).move(animals.get(k), animals.get(k).getSpeed());
                    }
                }
            }
        }
    }
}
