package Island;

import Animals.Animal;
import Animals.CreatorAnimals;
import Animals.Parameters;
import Animals.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Island {
    public static int WIDTH = 20;
    public static int HEIGHT = 10;
    public CreatorAnimals creatorAnimals = new CreatorAnimals();
    public static Location[][] locations = new Location[WIDTH][HEIGHT];


    public void initialize() {
        createIsland(WIDTH, HEIGHT);

    }

    public void createIsland(int WIDTH, int HEIGHT) {
        List<Animal> animals = creatorAnimals.getAnimals();
        int i = 0;
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                List<Plant> plants = creatorAnimals.plantCreate();
                List<Animal> animal = new ArrayList<>();
                int random = ThreadLocalRandom.current().nextInt(0, 100);
                locations[x][y] = new Location(x, y, animal, plants);
                if(random < 60){
                    if(i < animals.size()) {
                        animal.add(animals.get(i));
                        animals.get(i).setLocation(locations[x][y]);
                        i++;
                    }
                }


                for (Animal animal1 : animal) {
                    if(animal1 != null){
                        Parameters.countAnimalsOnIsland++;
                    }
                }
            }
        }
        System.out.println("Количество животных - " + animals.size() + " Заселилось на остров - "+ Parameters.countAnimalsOnIsland);

    }
}
