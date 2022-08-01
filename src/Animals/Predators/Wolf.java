package Animals.Predators;

public class Wolf extends Predators {
    public int canEatFromTable = 0;
    public int canBeEatenFromTable = 0;
    private int speed = 3;

    public Wolf(int i) {
        super(i);
    }

    public int getSpeed() {
        return speed;
    }
}
