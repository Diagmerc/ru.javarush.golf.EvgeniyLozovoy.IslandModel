package Animals.Predators;

import Animals.AnimalType;

public class Wolf extends Predators {
    private AnimalType animalType = AnimalType.Wolf;
    private double weight= animalType.getAnimalWeight();

    public Wolf(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
