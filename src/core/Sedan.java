/**
 * =====================================================================
 *                          SEDAN SINIFI
 *                    (Konforlu Binek Araç Tipi)
 * =====================================================================
 * 
 * Sedan, Vehicle sınıfından türeyen somut bir araç tipidir.
 * Konfor odaklı, 4 kapılı standart binek araçları temsil eder.
 * 
 * INHERITANCE (Kalıtım) Örneği:
 * ---------------------------------------------------------------------
 * - Vehicle sınıfının tüm özelliklerini (brand, model, dailyRate) miras alır
 * - getDetails() metodunu override ederek tip etiketini ekler
 * - getCost() metodunu miras alır, override etmez (değişiklik gerekmez)
 * 
 * @author Emre
 * @version 1.0
 */
package core;

/**
 * Sedan tipi araç sınıfı
 * 
 * Örnek Kullanım:
 * Sedan sedan = new Sedan("Mercedes", "C200", 1500);
 * sedan.getDetails(); // "[Sedan] Mercedes C200 (Comfort)"
 * sedan.getCost(); // 1500.0
 */
public class Sedan extends Vehicle {

    /**
     * Sedan Constructor (Yapıcı Metot)
     * 
     * super() ile üst sınıfın (Vehicle) yapıcısını çağırır.
     * Bu sayede brand, model ve dailyRate değerleri atanır.
     * 
     * @param brand Marka (örn: Mercedes, BMW, Audi)
     * @param model Model (örn: C200, 320i, A4)
     * @param price Günlük kiralama ücreti (TL)
     */
    public Sedan(String brand, String model, double price) {
        // super(): Üst sınıfın yapıcısını çağırır
        // Vehicle(brand, model, dailyRate) çalıştırılır
        super(brand, model, price);
    }

    /**
     * Sedan'ın detay bilgisini döndürür
     * 
     * @Override: Vehicle/Rentable'dan gelen metodu override eder
     * 
     *            super.getDetails(): Üst sınıftaki metodu çağırır -> "Mercedes
     *            C200"
     *            Bu metot: "[Sedan] Mercedes C200 (Comfort)" döndürür
     * 
     *            Decorator pattern'de bu metot zincirleme çağrılır:
     *            WithGPS -> Sedan.getDetails() -> "[Sedan] Mercedes C200 (Comfort)
     *            + GPS"
     * 
     * @return Tip etiketi + marka model + özellik açıklaması
     */
    @Override
    public String getDetails() {
        return "[Sedan] " + super.getDetails() + " (Comfort)";
    }
}
