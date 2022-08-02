package Animals.Herbivores;

import Animals.AnimalType;

public class Rabbit extends Herbivores {
    private AnimalType animalType = AnimalType.Rabbit;
    private double weight= animalType.getAnimalWeight();

    public Rabbit(int i) {
        super(i);
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }
}
