package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;

public class Mouse extends Herbivore {
    private AnimalType animalType = AnimalType.Mouse;
    private double weight= animalType.getAnimalWeight();

    public Mouse(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal reproduce() {
        return new Mouse(Parameters.countAnimalsOnIsland+1);
    }
}
