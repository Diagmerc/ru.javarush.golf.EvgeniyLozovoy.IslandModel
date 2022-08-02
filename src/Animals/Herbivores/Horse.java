package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Horse extends Herbivores {
    private AnimalType animalType = AnimalType.Horse;
    private double weight= animalType.getAnimalWeight();

    public Horse(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
