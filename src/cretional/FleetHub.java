package cretional;

import core.Car;
import core.Rentable;

// [2] FACTORY METHOD -> FleetHub
// İstenilen tipte aracı üretim bandından çıkarır.
public class FleetHub {
    public Rentable getVehicle(String category) {
        if (category.equalsIgnoreCase("Luxury")) {
            return new Car("Mercedes S-Class", 3000);
        } else if (category.equalsIgnoreCase("SUV")) {
            return new Car("Range Rover", 2000);
        } else {
            return new Car("Renault Clio", 800);
        }
    }
}
