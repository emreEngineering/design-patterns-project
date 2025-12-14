package behavioral;

// [9] STATE -> VehicleStatus
// Aracın durumuna göre davranışını değiştirir.
interface State {
    void rentCar(VehicleContext ctx);

    void returnCar(VehicleContext ctx);
}
