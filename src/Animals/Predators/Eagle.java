package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;


public class Eagle extends Predators {
    AnimalType animalType = AnimalType.Eagle;
    private double weight= animalType.getAnimalWeight();

    public Eagle(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
