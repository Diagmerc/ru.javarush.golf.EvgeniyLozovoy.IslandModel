package Animals;


import lombok.Getter;

@Getter
public enum AnimalType {
    Wolf(0,3,30,8,50), Snake(1,3,30,3,15),
    Fox(2,2,30,2,8), Bear(3,2,5,80,500),
    Eagle(4,3,20,1,6), Horse(5,2,20,60,400),
    Deer(6,2,20,50,300), Rabbit(7,2,150,0.45,2),
    Mouse(8,2,500,0.01,0.05), Goat(9,3,140,10,60),
    Sheep(10,3,140, 15,70), Hog(11,2,50,50,400),
    Buffalo(12,3,10,100,700), Duck(13,4,200,0.15,1),
    Worm(14,0,1000,0,0.01);

    private int chanseToEat;
    private int speed;
    private int maxTypeInLocation;
    private double needFoods;
    private double animalWeight;

    AnimalType(int chanseToEat, int speed, int maxTypeInLocation, double needFoods, double animalWeight) {
        this.chanseToEat = chanseToEat;
        this.speed = speed;
        this.maxTypeInLocation = maxTypeInLocation;
        this.needFoods = needFoods;
        this.animalWeight = animalWeight;
    }

    public int getChanseToEat() {
        return chanseToEat;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxTypeInLocation() {
        return maxTypeInLocation;
    }

    public double getNeedFoods() {
        return needFoods;
    }

    public double getAnimalWeight() {
        return animalWeight;
    }
}
