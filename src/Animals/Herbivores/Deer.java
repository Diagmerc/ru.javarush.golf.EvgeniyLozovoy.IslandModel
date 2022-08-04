package Animals.Herbivores;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;


public class Deer extends Herbivore {
    private AnimalType animalType = AnimalType.Deer;
    private double weight= animalType.getAnimalWeight();

    public Deer(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Deer(Parameters.countAnimalsOnIsland+1);
    }
}
