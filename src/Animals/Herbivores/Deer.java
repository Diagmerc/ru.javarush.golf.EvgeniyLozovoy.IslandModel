package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;

public class Deer extends Herbivores {
    private AnimalType animalType = AnimalType.Deer;
    private double weight= animalType.getAnimalWeight();

    public Deer(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
