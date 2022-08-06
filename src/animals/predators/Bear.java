package Animals.Predators;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bear extends Predator {
    private AnimalType animalType = AnimalType.Bear;
    private double weight= animalType.getAnimalWeight();

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal newAnimal() {
        return new Bear();
    }
}