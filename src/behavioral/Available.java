package behavioral;

class Available implements State {
    public void rentCar(VehicleContext ctx) {
        System.out.println("[Status] Araç artık KİRALIKTIR.");
        ctx.setCurrentState(new OnRoad());
    }

    public void returnCar(VehicleContext ctx) {
        System.out.println("[Status] HATA: Araba zaten garajda.");
    }
}
