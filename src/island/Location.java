package island;
import animals.Animal;
import animals.AnimalType;
import animals.MoveAnimal;
import animals.biota.Plant;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class Location implements Runnable {
       private int x;
       private int y;
       private List<Animal> animals;
       private List<Plant> plants;
       private final Lock lock = new ReentrantLock();

       public void setAnimals(List<Animal> animals) {
              this.animals = animals;
       }

       public Location(int x, int y, List<Animal> animals, List<Plant> plants) {
              this.x = x;
              this.y = y;
              this.animals = animals;
              this.plants = plants;
       }

       public void setAnimals(List<Animal> animals, Animal animal) {
              if(this.animals == null){this.animals = new ArrayList<>();}
              animals.add(animal);
       }

       public void setPlants(List<Plant> plants, Plant plant) {
              if(this.plants == null){this.plants = new ArrayList<>();}
              plants.add(plant);
       }

       public boolean getCountTypeAnimals(Animal animal) {
              boolean result = false;
              int count = 0;
              if(animal != null){
              for (Animal animal1 : this.animals) {
                     if(animal1.getAnimalType() == animal.getAnimalType()){
                            count++;
                     }
              }
              if(count < animal.getAnimalType().getMaxTypeInLocation()){
                     result = true;
              }}
              return result;
       }

       public void plantsGrowUp(){
              List<Plant> plantList = getPlants();
              if(!plants.isEmpty()) {
                     lock.lock();
                     try{
                            for (Plant plant : plantList) {
                                          setPlants(plants, plant.getPlant());
                            }
                     }finally {
                            lock.unlock();
                     }
              }
       }

       public synchronized void migration(Animal animal) {
              int moveSpeed = ThreadLocalRandom.current().nextInt( animal.getAnimalType().getSpeed() + 1);
              int random = ThreadLocalRandom.current().nextInt( 4);
              Location locationNext = null;
              switch (MoveAnimal.values()[random]) {
                     case UP :
                            if (x + moveSpeed < Island.locations.length - 1) {
                                   locationNext = Island.locations[x + moveSpeed][y];
                            }break;

                     case DOWN:
                            if (x - moveSpeed >= 0) {
                                   locationNext = Island.locations[x - moveSpeed][y];
                            }break;
                     case LEFT:
                            if (y + moveSpeed < Island.locations[Island.locations.length - 1].length) {
                                   locationNext = Island.locations[x][y + moveSpeed];
                            }break;
                     case RIGHT:
                            if (y - moveSpeed >= 0) {
                                   locationNext = Island.locations[x][y - moveSpeed];
                            }break;
              }
              if (locationNext != null && locationNext.getCountTypeAnimals(animal)) {
                     locationNext.setAnimals(locationNext.getAnimals(), animal);
                     this.animals.remove(animal);
              }
       }

       public synchronized void animalsDoSomthing() {
              lock.lock();
              try {
                     List<Animal> animalList = this.getAnimals();
                     List<Plant> plantsCopy = this.getPlants();
                     List<Animal> animalsCopy = new ArrayList<>(animalList);
                     if (!animalList.isEmpty()) {
                            for (Animal animal : animalsCopy) {
                                   animal.setWeight(animal.getWeight() - animal.getAnimalType().getAnimalWeight() * 0.1);
                                   if (animal.getWeight() < animal.getAnimalType().getAnimalWeight() * 0.2) {
                                          animalList.remove(animal);
                                   } else {
                                          animal.eat(animalList, plantsCopy);
                                          animal.reproduce(animalList);
                                          this.migration(animal);
                                   }
                            }
                     }
              }
              finally {
                     lock.unlock();
              }
       }

       public synchronized String countAnimalsTypes(){
              int count = 0;
              AnimalType[] values = AnimalType.values();
              StringBuilder types = new StringBuilder();
              for (AnimalType value : values) {
                     for (Animal animal : animals) {
                            if (value.getChanseToEat() == animal.getAnimalType().getChanseToEat()) {
                                   count++;
                            }
                     }
                     types.append(value.toString()).append(" ").append(count).append(" ");
                     count = 0;
              }
              return types.toString();
       }

       @Override
       public synchronized String toString() {

              return "--------------------------------------------------------------------------------------------------------------------------------------" + "\n"
                      + "Location[" + this.x + "][" + this.y + "]: " + "\n"
                      + "In location animals: " + countAnimalsTypes() + "\n";
       }

       @Override
       public void run() {
              animalsDoSomthing();
              plantsGrowUp();
       }
}
