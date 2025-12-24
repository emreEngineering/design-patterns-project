package core;

class SUV extends Vehicle {
    public SUV(String brand, String model, double price) {
        super(brand, model, price);
    }

    @Override
    public String getDetails() {
        return "[SUV] " + super.getDetails() + " (Off-Road)";
    }
}
