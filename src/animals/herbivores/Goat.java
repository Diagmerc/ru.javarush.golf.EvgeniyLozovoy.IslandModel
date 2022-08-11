package animals.herbivores;

import animals.Animal;
import animals.AnimalType;

public class Goat extends Herbivore {
    private AnimalType animalType = AnimalType.GOAT;
    private double weight= animalType.getAnimalWeight();

    @Override
    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal newAnimal() {
        return new Goat();
    }
}
