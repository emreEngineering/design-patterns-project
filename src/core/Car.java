package core;

// Temel Araç Sınıfı
public class Car implements Rentable {
    private String model;
    private double dailyRate;

    public Car(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
    }

    @Override
    public String getDetails() {
        return model;
    }

    @Override
    public double getCost() {
        return dailyRate;
    }
}
