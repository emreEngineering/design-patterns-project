package core;

/**
 * Elektrikli araç sınıfı
 * 
 * Örnek Kullanım:
 * ElectricCar ev = new ElectricCar("Tesla", "Model S", 2500);
 * ev.getDetails(); // "[EV] Tesla Model S (Eco-Friendly)"
 * ev.getCost(); // 2500.0
 */
public class ElectricCar extends Vehicle {

    /**
     * ElectricCar Constructor (Yapıcı Metot)
     * 
     * @param brand Marka (örn: Tesla, BMW, Porsche)
     * @param model Model (örn: Model S, i4, Taycan)
     * @param price Günlük kiralama ücreti (TL)
     */
    public ElectricCar(String brand, String model, double price) {
        // Üst sınıfın (Vehicle) yapıcısını çağır
        super(brand, model, price);
    }

    /**
     * Elektrikli aracın detay bilgisini döndürür
     * 
     * EV (Electric Vehicle) etiketi ve "Eco-Friendly" özelliği eklenir.
     * Bu, aracın çevre dostu olduğunu vurgular.
     */
    @Override
    public String getDetails() {
        return "[EV] " + super.getDetails() + " (Çevre Dostu)";
    }
}
