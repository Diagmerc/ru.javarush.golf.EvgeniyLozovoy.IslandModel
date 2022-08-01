package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Hog extends Herbivores {
    private AnimalType animalType = AnimalType.Hog;
    private int canEatFromTable = 11;
    private int canBeEatenFromTable = 11;
    private int speed = 2;

    public Hog(int i) {
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
