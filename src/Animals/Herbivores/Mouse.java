package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Mouse extends Herbivores {
    private AnimalType animalType = AnimalType.Mouse;
    public int canEatFromTable = 8;
    public int canBeEatenFromTable = 8;
    private int speed = 2;

    public Mouse(int i) {
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
