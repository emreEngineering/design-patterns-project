package structural;

import core.Rentable;

public class WithChildSeat extends FeatureAddon {
    public WithChildSeat(Rentable baseCar) {
        super(baseCar);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " + Çocuk Koltuğu";
    }

    @Override
    public double getCost() {
        return super.getCost() + 100;
    }
}
