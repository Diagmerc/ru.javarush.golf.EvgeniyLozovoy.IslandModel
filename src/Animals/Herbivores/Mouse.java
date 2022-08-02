package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;

public class Mouse extends Herbivores {
    private AnimalType animalType = AnimalType.Mouse;
    private double weight= animalType.getAnimalWeight();

    public Mouse(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
