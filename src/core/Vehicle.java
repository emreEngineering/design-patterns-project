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