package core;

class ElectricCar extends Vehicle {
    public ElectricCar(String brand, String model, double price) {
        super(brand, model, price);
    }

    @Override
    public String getDetails() {
        return "[EV] " + super.getDetails() + " (Eco-Friendly)";
    }
}
