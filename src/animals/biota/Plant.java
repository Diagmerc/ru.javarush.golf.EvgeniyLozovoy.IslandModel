package animals.biota;

import animals.Entity;

public class Plant extends Plants implements Entity {

    @Override
    public double getWeight() {
        return 1;
    }

    public Plant getPlant(){
        return new Plant();
    }
}
