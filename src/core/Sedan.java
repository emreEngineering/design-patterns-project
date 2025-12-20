package core;

public class Sedan extends Vehicle {
    public Sedan(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    @Override
    public String getDetails() {
        return "[Sedan] " + super.getDetails() + " (Comfort Edition)";
    }

}
