package structural;

import core.Rentable;

public class WithSunroof extends CarDecorator {
    public WithSunroof(Rentable car) {
        super(car);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " + Sunroof";
    }

    @Override
    public double getCost() {
        return super.getCost() + 150;
    }
}
