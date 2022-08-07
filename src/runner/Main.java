package runner;

import animals.Animal;
import animals.AnimalType;
import animals.CreatorAnimals;
import animals.herbivores.Worm;
import island.Island;
import parameters.Statistic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(2, 2);
        island.initialize();
        island.statistic.countAnimals();
        new Thread(() -> {
            while (!island.statistic.allAnimalsOnIsland.isEmpty()) {
                for (int i = 0; i < island.locations.length/2; i++) {
                    for (int j = 0; j < island.locations[i].length; j++) {
                        island.animalsDoSomthing(i,j);
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                for (int x = island.locations.length/2; x < island.locations.length; x++) {
                    for (int y= 0; y < island.locations[x].length; y++) {
                        island.animalsDoSomthing(x,y);
                    }
                }
            }
        }).start();
        island.statistic.countAnimals();
        System.out.println();
        System.out.println(island.statistic.allAnimalsOnIsland.size());
    }

}
