package behavioral;

class OnRoad implements State {
    public void rentCar(VehicleContext ctx) {
        System.out.println("[Status] HATA: Araba zaten yolda!");
    }

    public void returnCar(VehicleContext ctx) {
        System.out.println("[Status] Araba garaja döndü. Hasarlar kontrol ediliyor...");
        ctx.setCurrentState(new Available());
    }
}
