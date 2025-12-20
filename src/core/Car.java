package core;



// --- CORE KISMI ---
// Soyut Ebeveyn Sınıf (Abstract Parent Class)
// Artık doğrudan "new Vehicle()" diyemeyiz, alt sınıfları kullanacağız.
abstract class Vehicle implements Rentable {
    protected String brand;
    protected String model;
    protected double dailyRate;

    public Vehicle(String brand, String model, double dailyRate) {
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
    }

    @Override
    public String getDetails() {
        return brand + " " + model;
    }

    @Override
    public double getCost() {
        return dailyRate;
    }
}

// --- YENİ ARAÇ TİPLERİ (Concrete Classes) ---

public class Sedan extends Vehicle {
    public Sedan(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[Sedan] " + super.getDetails() + " (Comfort Edition)";
    }
}

public class SUV extends Vehicle {
    public SUV(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[SUV] " + super.getDetails() + " (4x4 Off-Road)";
    }
}

public class SportsCar extends Vehicle {
    public SportsCar(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[Sport] " + super.getDetails() + " (High Performance)";
    }
}

public class Minivan extends Vehicle {
    public Minivan(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[Van] " + super.getDetails() + " (7 Seats - Family)";
    }
}