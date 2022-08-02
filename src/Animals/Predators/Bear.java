package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;

public class Bear extends Predators {
    private AnimalType animalType = AnimalType.Bear;
    private double weight= animalType.getAnimalWeight();

    public Bear(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
