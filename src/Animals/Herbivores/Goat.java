package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Goat extends Herbivores {
    private AnimalType animalType = AnimalType.Goat;
    private double weight= animalType.getAnimalWeight();

    public Goat(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
