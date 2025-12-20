package core;

public class SportsCar extends Vehicle {
    public SportsCar(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[Sport] " + super.getDetails() + " (High Performance)";
    }
}
