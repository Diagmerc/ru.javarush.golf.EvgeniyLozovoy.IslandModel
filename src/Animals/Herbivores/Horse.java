package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Horse extends Herbivore {
    private AnimalType animalType = AnimalType.Horse;
    private double weight= animalType.getAnimalWeight();

    public Horse(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Horse(Parameters.countAnimalsOnIsland+1);
    }
}
