package Animals.Predators;
import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle extends Predator {
    AnimalType animalType = AnimalType.Eagle;
    private double weight= animalType.getAnimalWeight();

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal newAnimal() {
        return new Eagle();
    }
}
