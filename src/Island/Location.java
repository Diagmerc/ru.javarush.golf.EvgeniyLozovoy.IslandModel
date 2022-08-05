package Island;
import Animals.Animal;
import Animals.Move;
import Animals.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class Location {
       public int x;
       public int y;
       List<Animal> animals;
       List<Plant> plants;

       public Location(int x, int y, List<Animal> animals, List<Plant> plants) {
              this.x = x;
              this.y = y;
              this.animals = animals;
              this.plants = plants;
       }

       public List<Animal> getAnimals() {
              return animals;
       }

       public void setAnimals(List<Animal> animals, Animal animal) {
              this.animals = new ArrayList<>();
              animals.add(animal);
       }

       public boolean getCountTypeAnimals(Animal animal) {
              boolean result = false;
              int count = 0;
              for (Animal animal1 : this.animals) {
                     if(animal1.getAnimalType() == animal.getAnimalType()){
                            count++;
                     }
              }
              if(count < animal.getAnimalType().getMaxTypeInLocation()){
                     result = true;
              }
              return result;
       }

       public synchronized void move(Animal animal, Location[][] locations) {
              int moveSpeed = ThreadLocalRandom.current().nextInt(1, animal.getAnimalType().getSpeed() + 1);
              int random = ThreadLocalRandom.current().nextInt(0, 4);
              Location locationNext = null;
              switch (Move.values()[random]) {
                     case UP:
                            if (x + moveSpeed < locations.length - 1) {
                                   locationNext = locations[x + moveSpeed][y];
                                   break;
                            }
                            random = ThreadLocalRandom.current().nextInt(0, 4);
                     case DOWN:
                            if (x - moveSpeed >= 0) {
                                   locationNext = locations[x - moveSpeed][y];
                                   break;
                            }
                            random = ThreadLocalRandom.current().nextInt(0, 4);
                     case LEFT:
                            if (y + moveSpeed < locations[locations.length - 1].length) {
                                   locationNext = locations[x][y + moveSpeed];
                                   break;
                            }
                            random = ThreadLocalRandom.current().nextInt(0, 4);
                     case RIGHT:
                            if (y - moveSpeed >= 0) {
                                   locationNext = locations[x][y - moveSpeed];
                                   break;
                            }
                            random = ThreadLocalRandom.current().nextInt(0, 4);
              }
              if (locationNext != null && locationNext.getCountTypeAnimals(animal)) {
                     locationNext.setAnimals(locationNext.getAnimals(), animal);
                     this.animals.remove(animal);
                     System.out.println(animal.getClass().getSimpleName() + " сменил локацию " + locationNext.getX() + " " + locationNext.getY());
              }
       }
}
