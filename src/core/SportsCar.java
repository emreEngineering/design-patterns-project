package core;

class SportsCar extends Vehicle {
    public SportsCar(String brand, String model, double price) {
        super(brand, model, price);
    }

    @Override
    public String getDetails() {
        return "[Sport] " + super.getDetails() + " (High Performance)";
    }
}
