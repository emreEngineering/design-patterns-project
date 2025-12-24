package core;

class Minivan extends Vehicle {
    public Minivan(String brand, String model, double price) {
        super(brand, model, price);
    }

    @Override
    public String getDetails() {
        return "[Van] " + super.getDetails() + " (Family Size)";
    }
}
