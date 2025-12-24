package core;

class Sedan extends Vehicle {
    public Sedan(String brand, String model, double price) {
        super(brand, model, price);
    }

    @Override
    public String getDetails() {
        return "[Sedan] " + super.getDetails() + " (Comfort)";
    }
}
