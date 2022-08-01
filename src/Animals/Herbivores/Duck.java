package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Duck extends Herbivores {
    private AnimalType animalType = AnimalType.Duck;
    private int canEatFromTable = 13;
    private int canBeEatenFromTable = 13;
    private int speed = 4;

    public Duck(int i) {
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
