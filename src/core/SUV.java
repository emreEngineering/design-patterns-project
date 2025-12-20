package core;

public class SUV extends Vehicle {
    public SUV(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[SUV] " + super.getDetails() + " (4x4 Off-Road)";
    }
}
