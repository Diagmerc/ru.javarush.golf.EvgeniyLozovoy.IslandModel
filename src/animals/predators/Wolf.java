package animals.predators;
import animals.Animal;
import animals.AnimalType;

public class Wolf extends Predator {
    private AnimalType animalType = AnimalType.WOLF;
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
        return new Wolf();
    }
}
