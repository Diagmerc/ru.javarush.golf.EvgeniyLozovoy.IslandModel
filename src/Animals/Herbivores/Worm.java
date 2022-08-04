package Animals.Herbivores;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Worm extends Herbivore {
    private AnimalType animalType = AnimalType.Worm;
    private double weight= animalType.getAnimalWeight();

    public Worm(int i) {
        super(i);
    }

    @Override
    public void move() {
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Worm(Parameters.countAnimalsOnIsland+1);
    }
}
