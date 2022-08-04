package Animals.Herbivores;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;


public class Sheep extends Herbivore {
    private AnimalType animalType = AnimalType.Sheep;
    private double weight= animalType.getAnimalWeight();

    public Sheep(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Sheep(Parameters.countAnimalsOnIsland+1);
    }
}
