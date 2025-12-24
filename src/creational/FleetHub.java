package creational;

import core.*;

// [2] FACTORY METHOD: FleetHub
// İstemci "new core.Sedan()" demez, türü söyler (String), fabrika üretir.
public class FleetHub {
    public Rentable createVehicle(String type) {
        switch (type.toUpperCase()) {
            case "core.SUV":
                return new SUV("Range Rover", "Vogue", 3000);
            case "SEDAN":
                return new Sedan("Mercedes", "C200", 1500);
            case "SPORT":
                return new SportsCar("Ferrari", "488 Spider", 5000);
            case "FAMILY":
                return new Minivan("Volkswagen", "Transporter", 1200);
            case "ELECTRIC":
                return new ElectricCar("Tesla", "Model S", 2500);
            default:
                // Varsayılan Araç
                return new Sedan("Fiat", "Egea", 800);
        }
    }
}
