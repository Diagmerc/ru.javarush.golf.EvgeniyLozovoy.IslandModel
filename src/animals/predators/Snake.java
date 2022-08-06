package Animals.Predators;
import Animals.Animal;
import Animals.AnimalType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Snake extends Predator {
    private AnimalType animalType = AnimalType.Snake;
    private double weight= animalType.getAnimalWeight();

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }


    @Override
    public Animal newAnimal() {
        return new Snake();
    }
}
