/**
 * =====================================================================
 *                        SPORTS CAR SINIFI
 *                    (Yüksek Performanslı Spor Araç)
 * =====================================================================
 * 
 * SportsCar, Vehicle sınıfından türeyen somut bir araç tipidir.
 * Yüksek performanslı, lüks spor araçları temsil eder.
 * 
 * ÖZELLİKLER:
 * - Yüksek performans (High Performance)
 * - Güçlü motor ve hızlı hızlanma
 * - Sportif tasarım
 * - 2 kişilik kabin (genellikle)
 * 
 * ÖRNEK ARAÇLAR: Ferrari 488 Spider, Lamborghini Huracán, Porsche 911
 * 
 * @author Emre
 * @version 1.0
 */
package core;

/**
 * Spor araç sınıfı
 * 
 * Örnek Kullanım:
 * SportsCar sport = new SportsCar("Ferrari", "488 Spider", 5000);
 * sport.getDetails(); // "[Sport] Ferrari 488 Spider (High Performance)"
 * sport.getCost(); // 5000.0
 * 
 * Senaryo: Genç çift için romantik hafta sonu sürüşü
 * - Açılır tavan (sunroof) ile keyifli sürüş
 * - Prestijli görünüm
 */
public class SportsCar extends Vehicle {

    /**
     * SportsCar Constructor (Yapıcı Metot)
     * 
     * @param brand Marka (örn: Ferrari, Lamborghini, Porsche)
     * @param model Model (örn: 488 Spider, Huracán, 911)
     * @param price Günlük kiralama ücreti (TL) - genellikle yüksek
     */
    public SportsCar(String brand, String model, double price) {
        // Üst sınıfın (Vehicle) yapıcısını çağır
        super(brand, model, price);
    }

    /**
     * Spor aracın detay bilgisini döndürür
     * 
     * "[Sport]" etiketi araç tipini belirtir.
     * "(High Performance)" ifadesi yüksek performansı vurgular.
     * 
     * @return "[Sport] marka model (High Performance)" formatında string
     */
    @Override
    public String getDetails() {
        return "[Sport] " + super.getDetails() + " (High Performance)";
    }
}
