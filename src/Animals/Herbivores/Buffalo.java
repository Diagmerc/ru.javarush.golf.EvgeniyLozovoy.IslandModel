package Animals.Herbivores;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Buffalo extends Herbivore {
    private AnimalType animalType = AnimalType.Buffalo;
    private double weight = animalType.getAnimalWeight();

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Buffalo(Parameters.countAnimalsOnIsland+1);
    }

    public Buffalo(int i) {
        super(i);
    }

}
