package animals.predators;
import animals.Animal;
import animals.AnimalType;

public class Eagle extends Predator {
    AnimalType animalType = AnimalType.EAGLE;
    private double weight= animalType.getAnimalWeight();

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

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
    public Animal newAnimal() {
        return new Eagle();
    }
}
