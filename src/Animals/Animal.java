package Animals;

import Animals.Herbivores.*;
import Animals.Predators.*;
import Island.Island;
import Island.Location;
import lombok.Getter;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal {
    AnimalType animalType;
    Location location;
    private int numberOfAnimal;
    private double weight;

    public Animal(int numberOfAnimal) {
        this.numberOfAnimal = numberOfAnimal;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public int getNumberOfAnimal() {
        return numberOfAnimal;
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
        int chanceToEat = ParameterMatrix.chanceEat[this.animalType.getChanseToEat()][animal.animalType.getChanseToEat()];
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        if (random > chanceToEat) {
            result = true;
        }
        return result;
    }

    public void move() {
        int moveSpeed = ThreadLocalRandom.current().nextInt(1, this.getAnimalType().getSpeed() + 1);
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
            locationNext.setAnimals(locationNext.getAnimals(), this);
            locationCurrent.setAnimals(locationCurrent.getAnimals(), this);
            this.setLocation(locationNext);
            System.out.println(this.getClass().getSimpleName() + this.getNumberOfAnimal() + " сменил локацию " + this.location.getX() + " " + this.location.getY());
        }
    }
}
