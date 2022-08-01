package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;

public class Eagle extends Predators {
    AnimalType animalType = AnimalType.Eagle;
    public int canEatFromTable = 4;
    public int canBeEatenFromTable = 4;
    private int speed = 3;

    public Eagle(int i) {
        super(i);
    }

    public int getSpeed() {
        return speed;
    }
}
