package Animals.Herbivores;

import Animals.AnimalType;
import Animals.CreatorAnimals;

public class Buffalo extends Herbivores {
    private AnimalType animalType = AnimalType.Buffalo;
    private int canEatFromTable = 12;
    private int canBeEatenFromTable = 12;
    private int speed = 3;

    public Buffalo(int i) {
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
