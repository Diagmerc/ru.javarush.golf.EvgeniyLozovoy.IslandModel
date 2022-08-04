package Animals.Predators;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;


public class Eagle extends Predator {
    AnimalType animalType = AnimalType.Eagle;
    private double weight= animalType.getAnimalWeight();

    public Eagle(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Eagle(Parameters.countAnimalsOnIsland+1);
    }
}
