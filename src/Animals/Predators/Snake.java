package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;


public class Snake extends Predators {
    private AnimalType animalType = AnimalType.Snake;
    private double weight= animalType.getAnimalWeight();

    public Snake(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
