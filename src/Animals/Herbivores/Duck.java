package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;


public class Duck extends Herbivores {
    private AnimalType animalType = AnimalType.Duck;
    private double weight= animalType.getAnimalWeight();

    public Duck(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
