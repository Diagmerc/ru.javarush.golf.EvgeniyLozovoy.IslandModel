package runner;

import animals.Animal;
import island.Island;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(20, 20);
        island.initialize();
        for (int i = 0; i < island.height; i++) {
            for (int j = 0; j < island.width; j++) {
                List<Animal> animals = island.locations[i][j].getAnimals();
                if (animals.size() > 0) {
                    Iterator<Animal> iterator = animals.iterator();
                    while (iterator.hasNext()) {
                        Animal animal = iterator.next();
                        island.animalsDoSomthing(i, j, animals, animal);
                    }
                }
            }
        }
    }

}
