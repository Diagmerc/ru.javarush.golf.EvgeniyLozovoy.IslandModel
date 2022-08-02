package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;

public class Worm extends Herbivores {
    private AnimalType animalType = AnimalType.Worm;
    private double weight= animalType.getAnimalWeight();

    public Worm(int i) {
        super(i);
    }

    @Override
    public void move() {
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
