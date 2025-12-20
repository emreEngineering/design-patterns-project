package core;

public class Minivan extends Vehicle {
    public Minivan(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[Van] " + super.getDetails() + " (7 Seats - Family)";
    }
}
