package Animals;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public abstract class Animal implements Entity {
    AnimalType animalType;
    private int numberOfAnimal;
    private double weight;

    public abstract Animal newAnimal();

    public Animal reproduce(List<Animal> animals){
        Animal reproduced = null;
        for (int i = 0; i < animals.size(); i++) {
            if(this.getAnimalType() == animals.get(i).getAnimalType() &&
                    this != animals.get(i)){
                int random = ThreadLocalRandom.current().nextInt(0, 100);
                if (this.getAnimalType() == animals.get(i).getAnimalType() && random > 50) {
                    reproduced = this.newAnimal();
                }
            }
        }
        return reproduced;
    }

    public boolean eat(List<? extends Entity> animals){
        boolean result = false;
        for (Entity animal1 : animals) {
            boolean eatChanse = this.getEatChanse((Animal) animal1);
            if(eatChanse && this != animal1){
                animals.remove(animal1);
                this.setWeight(this.getWeight() + animal1.getWeight());
                System.out.println(this.getClass().getSimpleName() + " съел " + animal1.getClass().getSimpleName());
                result = true;
            }
        }
        return result;
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
}
