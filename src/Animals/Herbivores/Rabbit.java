package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Rabbit extends Herbivore {
    private AnimalType animalType = AnimalType.Rabbit;
    private double weight= animalType.getAnimalWeight();

    public Rabbit(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Rabbit(Parameters.countAnimalsOnIsland+1);
    }
}
