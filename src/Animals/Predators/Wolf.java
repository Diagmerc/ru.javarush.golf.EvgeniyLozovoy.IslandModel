package Animals.Predators;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Wolf extends Predator {
    private AnimalType animalType = AnimalType.Wolf;
    private double weight= animalType.getAnimalWeight();

    public Wolf(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Wolf(Parameters.countAnimalsOnIsland+1);
    }
}
