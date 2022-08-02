package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;

public class Hog extends Herbivores {
    private AnimalType animalType = AnimalType.Hog;
    private double weight= animalType.getAnimalWeight();

    public Hog(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
