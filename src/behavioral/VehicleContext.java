package behavioral;

// [4] DECORATOR -> structural.FeatureAddon

// [5] ADAPTER -> structural.PaymentGateway
// Eski banka sistemini bizim sistemimize entegre eder.


// Context Sınıfı
public class VehicleContext {
    private State currentState;

    public VehicleContext() {
        this.currentState = new Available(); // Başlangıç: Müsait
    }

    public void setCurrentState(State s) {
        this.currentState = s;
    }

    public void requestRent() {
        currentState.rentCar(this);
    }

    public void requestReturn() {
        currentState.returnCar(this);
    }
}