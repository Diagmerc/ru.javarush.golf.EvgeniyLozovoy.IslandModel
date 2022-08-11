package animals;
import animals.biota.Plant;
import animals.predators.Predator;
import parameters.Parameters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Entity {
    AnimalType animalType;
    private double weight;

    public abstract Animal newAnimal();

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(this.getAnimalType().getAnimalWeight() <= weight){
        this.weight = this.getAnimalType().getAnimalWeight() + weight;}else{
            this.weight = this.getAnimalType().getAnimalWeight();
        }
    }

    public void reproduce(List<Animal> animals){
        for (Animal animal : animals) {
            if(this.getAnimalType() == animal.getAnimalType() &&
                    this != animal){
                int random = ThreadLocalRandom.current().nextInt( 100);
                if (random < 5) {
                    animals.add(this.newAnimal());
                }
                break;
            }
        }
    }

    public void eat(List<Animal> entities, List<Plant> plants){
        List<Animal> entitiesCopy = new ArrayList<>(entities);
        for (Animal animal : entitiesCopy) {
            if (animal instanceof Predator) {
                boolean eatChanse = this.getEatChanse(animal);
                if (eatChanse) {
                    this.setWeight(animal.getWeight());
                    entities.remove(animal);
                }
            }else {
                ArrayList<Plant> plantsCopy = new ArrayList<>(plants);
                for (Plant plant : plantsCopy) {
                    this.setWeight(plant.getWeight());
                    plant.setNumberOfPlantsOnIsland(plant.getNumberOfPlantsOnIsland() -1);
                    plants.remove(plant);
                }
            }
        }
    }

    public boolean getEatChanse(Animal animal) {
        boolean result = false;
        int chanceToEat = Parameters.chanceEat[this.getAnimalType().getChanseToEat()][animal.getAnimalType().getChanseToEat()];
        int random = ThreadLocalRandom.current().nextInt( 101);
        if (random < chanceToEat && animal.getWeight() <= animal.getWeight() - animal.getAnimalType().getNeedFoods()) {
            result = true;
        }
        return result;
    }


}
