package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;
import Animals.Predators.Predator;

public class Bear extends Predator {
    private AnimalType animalType = AnimalType.Bear;
    private double weight= animalType.getAnimalWeight();

    public Bear(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Bear(Parameters.countAnimalsOnIsland+1);
    }
}
