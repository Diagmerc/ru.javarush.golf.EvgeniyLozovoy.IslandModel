package parameters;

import animals.Animal;
import animals.AnimalType;
import animals.CreatorAnimals;

import java.util.ArrayList;
import java.util.List;

public class Statistic {
    public List<Animal> allAnimalsOnIsland = new ArrayList<>();

    public void countAnimals(){
        int count = 0;
        AnimalType[] values = AnimalType.values();
        for (int i = 0; i < values.length; i++) {
                for (Animal animal : allAnimalsOnIsland) {
                    if(values[i].getChanseToEat() == animal.getAnimalType().getChanseToEat()){
                        count++;
                    }
                }
            System.out.print(values[i] + " " + count + " ");
                count = 0;
            }
    }
}
