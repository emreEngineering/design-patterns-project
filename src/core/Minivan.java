/**
 * =====================================================================
 *                         MINIVAN SINIFI
 *                    (Aile Tipi Geniş Araç)
 * =====================================================================
 * 
 * Minivan, Vehicle sınıfından türeyen somut bir araç tipidir.
 * Geniş iç hacimli, aile odaklı araçları temsil eder.
 * 
 * ÖZELLİKLER:
 * - 7-8 kişilik oturma kapasitesi
 * - Geniş bagaj alanı (Family Size)
 * - Konforlu uzun yolculuk
 * - Çocuk dostu özellikler
 * 
 * ÖRNEK ARAÇLAR: Volkswagen Transporter, Mercedes Vito, Ford Tourneo
 * 
 * @author Emre
 * @version 1.0
 */
package core;

/**
 * Minivan (aile aracı) sınıfı
 * 
 * Örnek Kullanım:
 * Minivan van = new Minivan("Volkswagen", "Transporter", 1200);
 * van.getDetails(); // "[Van] Volkswagen Transporter (Family Size)"
 * van.getCost(); // 1200.0
 * 
 * Senaryo: Aile tatili için ideal tercih
 * - Geniş alan sayesinde çocuk koltuğu kolayca yerleştirilebilir
 * - Kış lastiği ile güvenli tatil sürüşü
 */
public class Minivan extends Vehicle {

    /**
     * Minivan Constructor (Yapıcı Metot)
     * 
     * @param brand Marka (örn: Volkswagen, Mercedes, Ford)
     * @param model Model (örn: Transporter, Vito, Tourneo)
     * @param price Günlük kiralama ücreti (TL)
     */
    public Minivan(String brand, String model, double price) {
        // Üst sınıfın (Vehicle) yapıcısını çağır
        super(brand, model, price);
    }

    /**
     * Minivan'ın detay bilgisini döndürür
     * 
     * "[Van]" etiketi araç tipini belirtir.
     * "(Family Size)" ifadesi geniş aile aracı olduğunu vurgular.
     * 
     * @return "[Van] marka model (Family Size)" formatında string
     */
    @Override
    public String getDetails() {
        return "[Van] " + super.getDetails() + " (Family Size)";
    }
}
