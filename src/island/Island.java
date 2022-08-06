package Island;
import Animals.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Island {
    public int width;
    public int height;
    public CreatorAnimals creatorAnimals = new CreatorAnimals();
    public Location[][] locations;
    public int countAnimalsOnIsland = 0;
    public int countPlantsOnIsland = 0;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void initialize() {
        locations = new Location[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                List<Plant> plants = creatorAnimals.plantCreate();
                List<Animal> animals = creatorAnimals.getAnimals();
                int random = ThreadLocalRandom.current().nextInt(10);
                locations[x][y] = new Location(x,y, animals, plants);
                if (random < 6) {
                    countAnimalsOnIsland += animals.size();
                    countPlantsOnIsland += plants.size();
                }
            }
        }
        System.out.println("Количество животных - " + countAnimalsOnIsland + ". Количество растений" + countPlantsOnIsland);
    }

    public void animalsDoSomthing(int i, int j, List<Animal> animals, Animal animal) {
        int random = ThreadLocalRandom.current().nextInt(3);
        switch (random) {
            case 0 -> animal.eat(animals);
            case 1 -> animal.reproduce(animals);
            case 2 -> locations[i][j].move(animal, locations);
        }
        animal.setWeight(animal.getWeight() - animal.getWeight() * 0.1);
    }
}

