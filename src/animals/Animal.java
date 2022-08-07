package animals;
import lombok.Getter;
import lombok.Setter;
import parameters.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public abstract class Animal implements Entity {
    AnimalType animalType;
    private int numberOfAnimal;
    private double weight;

    public abstract Animal newAnimal();

    public void reproduce(List<Animal> animals, List<Animal> allAnimalList){
        List<Animal> animalsCopy = animals;
        for (Animal animal : animalsCopy) {
            if(this.getAnimalType() == animal.getAnimalType() &&
                    this != animals){
                int random = ThreadLocalRandom.current().nextInt( 100);
                if (this.getAnimalType() == animal.getAnimalType() && random < 30) {
                    animals.add(this.newAnimal());
                    allAnimalList.add(this.newAnimal());
                    System.out.println("New " + this.getClass().getSimpleName());
                    break;
                }
            }
        }
    }

    public void eat(List<? extends Entity> entities, List<Animal> allAnimalList){
        boolean result = false;
        List<? extends Entity> entitiesCopy = new ArrayList<>(entities);
        for (Entity entity : entitiesCopy) {
            boolean eatChanse = this.getEatChanse((Animal) entity);
            if(eatChanse && this != entity){
                entities.remove(entity);
                allAnimalList.remove(entity);
                this.setWeight(this.getWeight() + entity.getWeight());
                System.out.println(this.getClass().getSimpleName() + " съел " + entity.getClass().getSimpleName());
                break;
            }
        }
    }

    public boolean getEatChanse(Animal animal) {
        boolean result = false;
        int chanceToEat = Parameters.chanceEat[this.getAnimalType().getChanseToEat()][animal.getAnimalType().getChanseToEat()];
        int random = ThreadLocalRandom.current().nextInt(1, 101);
        if (random < chanceToEat) {
            result = true;
        }
        return result;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
