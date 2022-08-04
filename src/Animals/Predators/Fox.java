package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Fox extends Predator {
    private AnimalType animalType = AnimalType.Fox;
    private double weight= animalType.getAnimalWeight();

    public Fox(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Fox(Parameters.countAnimalsOnIsland+1);
    }
}
