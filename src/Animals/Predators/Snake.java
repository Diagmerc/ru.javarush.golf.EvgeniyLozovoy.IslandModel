package Animals.Predators;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;


public class Snake extends Predator {
    private AnimalType animalType = AnimalType.Snake;
    private double weight= animalType.getAnimalWeight();

    public Snake(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }


    @Override
    public Animal reproduce() {
        return new Snake(Parameters.countAnimalsOnIsland+1);
    }
}
