/**
 * =====================================================================
 *                      ELECTRIC CAR SINIFI
 *                    (Elektrikli Araç Tipi)
 * =====================================================================
 * 
 * ElectricCar, Vehicle sınıfından türeyen somut bir araç tipidir.
 * Çevre dostu, elektrik motorlu araçları temsil eder.
 * 
 * ÖZELLİKLER:
 * - Sıfır emisyon (Eco-Friendly)
 * - Düşük işletme maliyeti
 * - Sessiz sürüş deneyimi
 * - Yüksek tork ve hızlanma
 * 
 * ÖRNEK ARAÇLAR: Tesla Model S, BMW i4, Mercedes EQS
 * 
 * @author Emre
 * @version 1.0
 */
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
     * 
     * @return "[EV] marka model (Eco-Friendly)" formatında string
     */
    @Override
    public String getDetails() {
        return "[EV] " + super.getDetails() + " (Eco-Friendly)";
    }
}
