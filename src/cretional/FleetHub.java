package cretional;

import core.*;

// --- FACTORY (FleetHub) ---
public class FleetHub {
    // İstenilen kategoriye göre özel araç tipi üretir
    public Rentable getVehicle(String category) {
        if (category.equalsIgnoreCase("Economy")) {
            return new Sedan("Fiat", "Egea", 800);

        } else if (category.equalsIgnoreCase("Comfort")) {
            return new Sedan("Toyota", "Corolla", 1200);

        } else if (category.equalsIgnoreCase("SUV")) {
            return new SUV("Range Rover", "Sport", 2500);

        } else if (category.equalsIgnoreCase("Luxury")) {
            return new SportsCar("Porsche", "911 Carrera", 5000);

        } else if (category.equalsIgnoreCase("Family")) {
            return new Minivan("Mercedes", "Vito", 1800);

        } else {
            // Varsayılan araç
            return new Sedan("Renault", "Clio", 600);
        }
    }
}