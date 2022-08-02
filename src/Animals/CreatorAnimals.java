package Animals;

import Animals.Herbivores.*;
import Animals.Predators.*;
import Island.Island;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreatorAnimals {
//    public Herbivores herbivorsCreate(){
//        int random = ThreadLocalRandom.current().nextInt(0, 100);
//        Herbivores herbivores = null;
//        if(random < 35){
//            int iRandom = ThreadLocalRandom.current().nextInt(0, 10);
//            switch(HerbivoresType.values()[iRandom]){
//                case Buffalo:
//                    herbivores = new Buffalo();
//                    break;
//                case Deer:
//                    herbivores = new Deer();
//                    break;
//                case Duck:
//                    herbivores = new Duck();
//                    break;
//                case Goat:
//                    herbivores = new Goat();
//                    break;
//                case Hog:
//                    herbivores = new Hog();
//                    break;
//                case Horse:
//                    herbivores = new Horse();
//                    break;
//                case Mouse:
//                    herbivores = new Mouse();
//                    break;
//                case Rabbit:
//                    herbivores = new Rabbit();
//                    break;
//                case Sheep:
//                    herbivores = new Sheep();
//                    break;
//                case Сaterpillar:
//                    herbivores = new Сaterpillar();
//                    break;
//            }
//        }
//        return herbivores;
//    }

//    public Predators predatorsCreate(){
//        int random = ThreadLocalRandom.current().nextInt(0, 100);
//        Predators predators = null;
//        if(random < 30){
//            int iRandom = ThreadLocalRandom.current().nextInt(0, 5);
//            switch(PredatorsType.values()[iRandom]){
//                case Bear:
//                    predators = new Bear();
//                    break;
//                case Eagle:
//                    predators = new Eagle();
//                    break;
//                case Fox:
//                    predators = new Fox();
//                    break;
//                case Snake:
//                    predators = new Snake();
//                    break;
//                case Wolf:
//                    predators = new Wolf();
//                    break;
//            }
//        }
//        return predators;
//    }

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
        int random = ThreadLocalRandom.current().nextInt(2, 10);
        for (int i = 0; i < random; i++) {
            generatedAnimals.add(new Buffalo(i));
            generatedAnimals.add(new Deer(i));
            generatedAnimals.add(new Duck(i));
            generatedAnimals.add(new Goat(i));
            generatedAnimals.add(new Hog(i));
            generatedAnimals.add(new Horse(i));
            generatedAnimals.add(new Mouse(i));
            generatedAnimals.add(new Rabbit(i));
            generatedAnimals.add(new Sheep(i));
            generatedAnimals.add(new Worm(i));
            generatedAnimals.add(new Bear(i));
            generatedAnimals.add(new Eagle(i));
            generatedAnimals.add(new Fox(i));
            generatedAnimals.add(new Snake(i));
            generatedAnimals.add(new Wolf(i));

        }
        return generatedAnimals;
    }
}

