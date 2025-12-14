package structural;

import core.Rentable;

public class WithGPS extends FeatureAddon {
    public WithGPS(Rentable baseCar) {
        super(baseCar);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " + GPS Navigasyonu";
    }

    @Override
    public double getCost() {
        return super.getCost() + 50;
    }
}
