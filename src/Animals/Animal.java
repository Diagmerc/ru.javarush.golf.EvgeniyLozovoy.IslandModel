package Animals;

import Animals.Herbivores.*;
import Animals.Predators.*;
import Island.Island;
import Island.Location;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal {
    AnimalType animalType;
    public int canEatFromTable;
    public int canBeEatenFromTable;
    Location location;
    private int speed;
    private int numberOfAnimal;

    public Animal(int numberOfAnimal) {
        this.numberOfAnimal = numberOfAnimal;
    }

    public int getNumberOfAnimal() {
        return numberOfAnimal;
    }

    public int getSpeed() {
        return speed;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean reproduce(Animal animal) {
        boolean result = false;
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        if (animal.animalType == this.animalType && random > 50) {
            result = true;
        }
        return result;
    }

    public boolean eat(Animal animal) {
        boolean result = false;
        int chanceToEat = ParameterMatrix.chanceToEat[this.canEatFromTable][animal.canBeEatenFromTable];
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        if (random > chanceToEat) {
            result = true;
        }
        return result;
    }

    public void move(Animal animal, int speed) {
        int moveSpeed = ThreadLocalRandom.current().nextInt(1, speed + 1);
        int random = ThreadLocalRandom.current().nextInt(0, 4);
        Location locationCurrent = Island.locations[location.getX()][location.getY()];
        Location locationNext = null;
        switch (Move.values()[random]) {
            case UP:
                if (location.getX() + moveSpeed < Island.HEIGHT) {
                    locationNext = Island.locations[location.getX() + moveSpeed][location.getY()];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
            case DOWN:
                if (location.getX() - moveSpeed >= 0) {
                    locationNext = Island.locations[location.getX() - moveSpeed][location.getY()];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
            case LEFT:
                if (location.getY() + moveSpeed < Island.WIDTH) {
                    locationNext = Island.locations[location.getX()][location.getY() + moveSpeed];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
            case RIGHT:
                if (location.getY() - moveSpeed >= 0) {
                    locationNext = Island.locations[location.getX()][location.getY() - moveSpeed];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
        }
        if (locationNext != null) {
            locationNext.setAnimals(locationNext.getAnimals(), animal);
            locationCurrent.setAnimals(locationCurrent.getAnimals(), animal);
            animal.setLocation(locationNext);
            System.out.println(animal.getClass().getSimpleName() + animal.getNumberOfAnimal() + " сменил локацию " + animal.location.getX() + " " + animal.location.getY());
        }
    }
}
