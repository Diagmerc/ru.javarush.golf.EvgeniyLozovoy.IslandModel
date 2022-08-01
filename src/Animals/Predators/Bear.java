package Animals.Predators;

import Animals.Animal;

public class Bear extends Predators {
    public int canEatFromTable = 3;
    public int canBeEatenFromTable = 3;
    private int speed = 2;

    public Bear(int i) {
        super(i);
    }

    public int getSpeed() {
        return speed;
    }


}
