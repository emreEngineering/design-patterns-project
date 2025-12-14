package structural;

import core.Rentable;

// Araca dinamik özellik ekler (Miras almadan genişletme).
abstract class FeatureAddon implements Rentable {
    protected Rentable baseCar;

    public FeatureAddon(Rentable baseCar) {
        this.baseCar = baseCar;
    }

    public String getDetails() {
        return baseCar.getDetails();
    }

    public double getCost() {
        return baseCar.getCost();
    }
}
