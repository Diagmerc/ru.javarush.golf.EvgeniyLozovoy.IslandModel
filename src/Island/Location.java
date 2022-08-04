package Island;
import Animals.Animal;
import Animals.Entity;
import Animals.Herbivores.Herbivore;
import Animals.Parameters;
import Animals.Plant;
import Animals.Predators.Predator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
       private int x;
       private int y;
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

       public int getX() {
              return x;
       }

       public int getY() {
              return y;
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


}
