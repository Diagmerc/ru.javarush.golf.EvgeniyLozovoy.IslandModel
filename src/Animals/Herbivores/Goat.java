package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Goat extends Herbivores {
    private AnimalType animalType = AnimalType.Goat;
    private int canEatFromTable = 9;
    private int canBeEatenFromTable = 9;
    private int speed = 3;

    public Goat(int i) {
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
