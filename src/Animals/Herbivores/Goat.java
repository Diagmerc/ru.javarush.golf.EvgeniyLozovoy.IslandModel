package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Goat extends Herbivore {
    private AnimalType animalType = AnimalType.Goat;
    private double weight= animalType.getAnimalWeight();

    public Goat(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Goat(Parameters.countAnimalsOnIsland+1);
    }
}
