package animals;



public enum AnimalType {
    WOLF(0,3,30,8,50), SNAKE(1,3,30,3,15),
    FOX(2,2,30,2,8), BEAR(3,2,5,80,500),
    EAGLE(4,3,20,1,6), HORSE(5,2,20,60,400),
    DEER(6,2,20,50,300), RABBIT(7,2,150,0.45,2),
    MOUSE(8,2,500,0.01,0.05), GOAT(9,3,140,10,60),
    SHEEP(10,3,140, 15,70), HOG(11,2,50,50,400),
    BUFFALO(12,3,10,100,700), DUCK(13,4,200,0.15,1),
    WORM(14,0,1000,0,0.01);

    private final int chanseToEat;
    private final int speed;
    private final int maxTypeInLocation;
    private final double needFoods;
    private final double animalWeight;

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
