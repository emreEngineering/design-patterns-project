/**
 * =====================================================================
 *                           SUV SINIFI
 *                    (Arazi/Şehir Tipi Araç)
 * =====================================================================
 * 
 * SUV (Sport Utility Vehicle), Vehicle sınıfından türeyen somut bir araç tipidir.
 * Arazi kabiliyetine sahip, geniş iç hacimli araçları temsil eder.
 * 
 * ÖZELLİKLER:
 * - Yüksek sürüş pozisyonu
 * - Arazi kabiliyeti (Off-Road)
 * - Geniş bagaj hacmi
 * 
 * @author Emre
 * @version 1.0
 */
package core;

/**
 * SUV tipi araç sınıfı
 * 
 * Örnek Kullanım:
 * SUV suv = new SUV("Range Rover", "Vogue", 3000);
 * suv.getDetails(); // "[SUV] Range Rover Vogue (Off-Road)"
 * suv.getCost(); // 3000.0
 */
public class SUV extends Vehicle {

    /**
     * SUV Constructor (Yapıcı Metot)
     * 
     * @param brand Marka (örn: Range Rover, BMW, Mercedes)
     * @param model Model (örn: Vogue, X5, GLE)
     * @param price Günlük kiralama ücreti (TL)
     */
    public SUV(String brand, String model, double price) {
        // Üst sınıfın (Vehicle) yapıcısını çağır
        super(brand, model, price);
    }

    /**
     * SUV'un detay bilgisini döndürür
     * 
     * SUV'lar arazi kabiliyetini vurgulamak için "(Off-Road)" etiketi taşır.
     * 
     * @return "[SUV] marka model (Off-Road)" formatında string
     */
    @Override
    public String getDetails() {
        return "[SUV] " + super.getDetails() + " (Off-Road)";
    }
}
