package Animals;
import Island.Island;
import Island.Location;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal implements Entity {
    AnimalType animalType;
    Location location;
    private int numberOfAnimal;
    private double weight;

    public Animal(int numberOfAnimal) {
        this.numberOfAnimal = numberOfAnimal;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public int getNumberOfAnimal() {
        return numberOfAnimal;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract Animal reproduce();

    public Animal searchForACouple(List<Animal> animals){
        Animal result = null;
        for (int i = 0; i < animals.size(); i++) {
            if(this.getAnimalType() == animals.get(i).getAnimalType() &&
                    this != animals.get(i)){
                int random = ThreadLocalRandom.current().nextInt(0, 100);
                if (this.getAnimalType() == animals.get(i).getAnimalType() && random > 50) {
                    result = animals.get(i);
                }
            }
        }
        return result;
    }

    public void reproduceAndSetCoordinateToAnimal(Animal animal, List<Animal> animals){
        Animal reproducedAnimal = animal.reproduce();
        animals.add(reproducedAnimal);
        reproducedAnimal.setLocation(animal.getLocation());
    }

    public boolean searchEat(List<? extends Object> animals){
        boolean result = false;
        for (Object animal1 : animals) {
            if(this.eat((Animal) animal1) && this != animal1){
                animals.remove(animal1);
                this.setWeight(((Animal) animal1).getWeight());
                System.out.println(this.getClass().getSimpleName() + " съел " + animal1.getClass().getSimpleName());
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean eat(Animal animal) {
        boolean result = false;
        int chanceToEat = Parameters.chanceEat[this.getAnimalType().getChanseToEat()][animal.getAnimalType().getChanseToEat()];
        int random = ThreadLocalRandom.current().nextInt(1, 101);
        if (random > chanceToEat) {
            result = true;
        }
        return result;
    }

    public void move() {
        int moveSpeed = ThreadLocalRandom.current().nextInt(1, this.getAnimalType().getSpeed() + 1);
        int random = ThreadLocalRandom.current().nextInt(0, 4);
        Location locationCurrent = Island.locations[location.getX()][location.getY()];
        Location locationNext = null;
        switch (Move.values()[random]) {
            case UP:
                if (location.getX() + moveSpeed < Island.HEIGHT) {
                    locationNext = Island.locations[location.getX() + moveSpeed][location.getY()];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
            case DOWN:
                if (location.getX() - moveSpeed >= 0) {
                    locationNext = Island.locations[location.getX() - moveSpeed][location.getY()];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
            case LEFT:
                if (location.getY() + moveSpeed < Island.WIDTH) {
                    locationNext = Island.locations[location.getX()][location.getY() + moveSpeed];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
            case RIGHT:
                if (location.getY() - moveSpeed >= 0) {
                    locationNext = Island.locations[location.getX()][location.getY() - moveSpeed];
                    break;
                }
                random = ThreadLocalRandom.current().nextInt(0, 4);
        }
        if (locationNext != null && locationNext.getCountTypeAnimals(this)) {
            locationNext.setAnimals(locationNext.getAnimals(), this);
            locationCurrent.setAnimals(locationCurrent.getAnimals(), this);
            this.setLocation(locationNext);
            System.out.println(this.getClass().getSimpleName() + this.getNumberOfAnimal() + " сменил локацию " + this.location.getX() + " " + this.location.getY());
        }
    }
}
