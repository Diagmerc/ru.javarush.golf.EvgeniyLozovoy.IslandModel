package Animals;
import Animals.Herbivores.*;
import Animals.Predators.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreatorAnimals {

    public List<Plant> plantCreate() {
        List<Plant> plants = new ArrayList<>();
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        Plant plant = null;
        if (random < 50) {
            plant = new Plant();
        }
        if (plant != null) {
            plants.add(plant);
        }
        return plants;
    }

    public List<Animal> getAnimals() {
        List<Animal> generatedAnimals = new ArrayList<>();
        int random = ThreadLocalRandom.current().nextInt(1, 4);
        for (int i = 0; i < random; i++) {
            generatedAnimals.add(new Buffalo());
            generatedAnimals.add(new Deer());
            generatedAnimals.add(new Duck());
            generatedAnimals.add(new Goat());
            generatedAnimals.add(new Hog());
            generatedAnimals.add(new Horse());
            generatedAnimals.add(new Mouse());
            generatedAnimals.add(new Rabbit());
            generatedAnimals.add(new Sheep());
            generatedAnimals.add(new Worm());
            generatedAnimals.add(new Bear());
            generatedAnimals.add(new Eagle());
            generatedAnimals.add(new Fox());
            generatedAnimals.add(new Snake());
            generatedAnimals.add(new Wolf());

        }
        return generatedAnimals;
    }
}

