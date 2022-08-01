package Animals.Predators;

import Animals.Animal;

public class Fox extends Predators {
    public int canEatFromTable = 2;
    public int canBeEatenFromTable = 2;

    public Fox(int i) {
        super(i);
    }

    public int getSpeed() {
        return speed;
    }

    private int speed = 2;
}
