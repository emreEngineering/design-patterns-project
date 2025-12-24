package structural;

import core.Rentable;

// [3] DECORATOR: FeatureAddon (Süsleyici)
// Araca dinamik özellik eklemek için kullanılır (Miras yerine Wrapper).
abstract class CarDecorator implements Rentable {
    protected Rentable tempCar; // İçinde ana aracı tutar

    public CarDecorator(Rentable car) {
        this.tempCar = car;
    }

    public String getDetails() {
        return tempCar.getDetails();
    }

    public double getCost() {
        return tempCar.getCost();
    }
}
