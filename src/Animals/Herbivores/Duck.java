package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;
import lombok.Getter;


public class Duck extends Herbivore {
    private AnimalType animalType = AnimalType.Duck;
    private double weight= animalType.getAnimalWeight();

    public Duck(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Duck(Parameters.countAnimalsOnIsland+1);
    }
}
