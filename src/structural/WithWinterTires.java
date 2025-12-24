package structural;

import core.Rentable;

public class WithWinterTires extends CarDecorator {
    public WithWinterTires(Rentable car) {
        super(car);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " + Winter Tires";
    }

    @Override
    public double getCost() {
        return super.getCost() + 80;
    }
}
