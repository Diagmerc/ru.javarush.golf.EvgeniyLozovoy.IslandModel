package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Deer extends Herbivores {
    private AnimalType animalType = AnimalType.Deer;
    private int canEatFromTable = 6;
    private int canBeEatenFromTable = 6;
    private int speed = 2;

    public Deer(int i) {
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
