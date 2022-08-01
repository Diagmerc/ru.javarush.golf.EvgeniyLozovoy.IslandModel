package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Worm extends Herbivores {
    private AnimalType animalType = AnimalType.Сaterpillar;
    private int canEatFromTable = 14;
    private int canBeEatenFromTable = 14;
    private int speed = 0;

    public Worm(int i) {
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

    @Override
    public void move(Animal animal, int speed) {
    }
}
