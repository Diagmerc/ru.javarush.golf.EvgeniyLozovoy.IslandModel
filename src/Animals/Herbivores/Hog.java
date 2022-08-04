package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;
import lombok.Getter;

public class Hog extends Herbivore {
    private AnimalType animalType = AnimalType.Hog;
    private double weight= animalType.getAnimalWeight();

    public Hog(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Hog(Parameters.countAnimalsOnIsland+1);
    }
}
