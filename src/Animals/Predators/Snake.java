package Animals.Predators;

import Animals.Animal;

public class Snake extends Predators {
    public int canEatFromTable = 1;
    public int canBeEatenFromTable = 1;
    private int speed = 3;

    public Snake(int i) {
        super(i);
    }

    public int getSpeed() {
        return speed;
    }
}
