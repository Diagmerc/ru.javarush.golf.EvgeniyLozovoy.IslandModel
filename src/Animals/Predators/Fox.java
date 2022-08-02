package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;

public class Fox extends Predators {
    private AnimalType animalType = AnimalType.Fox;
    private double weight= animalType.getAnimalWeight();

    public Fox(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
