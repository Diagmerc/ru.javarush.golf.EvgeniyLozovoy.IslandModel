package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;

public class Sheep extends Herbivores {
    private AnimalType animalType = AnimalType.Sheep;
    private double weight= animalType.getAnimalWeight();

    public Sheep(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
