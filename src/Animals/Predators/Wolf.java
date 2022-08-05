package Animals.Predators;
import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wolf extends Predator {
    private AnimalType animalType = AnimalType.Wolf;
    private double weight= animalType.getAnimalWeight();


    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal newAnimal() {
        return new Wolf();
    }
}
