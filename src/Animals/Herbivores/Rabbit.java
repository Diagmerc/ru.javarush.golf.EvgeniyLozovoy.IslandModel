package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Rabbit extends Herbivores {
    private AnimalType animalType = AnimalType.Rabbit;
    public int canEatFromTable = 7;
    public int canBeEatenFromTable = 7;
    private int speed = 2;

    public Rabbit(int i) {
        super(i);
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public int getCanEatFromTable() {
        return canEatFromTable;
    }

    public int getCanBeEatenFromTable() {
        return canBeEatenFromTable;
    }

    public int getSpeed() {
        return speed;
    }
}
