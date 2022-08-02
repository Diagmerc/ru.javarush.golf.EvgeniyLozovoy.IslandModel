package Animals.Herbivores;

import Animals.AnimalType;

public class Buffalo extends Herbivores {
    private AnimalType animalType = AnimalType.Buffalo;
    private double weight = animalType.getAnimalWeight();

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }

    public Buffalo(int i) {
        super(i);
    }

}
