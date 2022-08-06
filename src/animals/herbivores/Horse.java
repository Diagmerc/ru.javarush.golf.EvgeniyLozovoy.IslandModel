package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalType;
import Animals.Parameters;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Horse extends Herbivore {
    private AnimalType animalType = AnimalType.Horse;
    private double weight= animalType.getAnimalWeight();

    @Override
    public AnimalType getAnimalType() {
        return this.animalType;
    }

    @Override
    public Animal newAnimal() {
        return new Horse();
    }
}