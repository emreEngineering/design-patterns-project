/**
 * =====================================================================
 *                   FLEET HUB - FACTORY METHOD PATTERN
 *                    (Araç Üretim Fabrikası)
 * =====================================================================
 * 
 * Bu sınıf, FACTORY METHOD (Fabrika Metodu) tasarım desenini uygular.
 * İstemci kodu hangi araç tipini istediğini söyler, fabrika uygun aracı üretir.
 * 
 * FACTORY PATTERN NEDİR?
 * ---------------------------------------------------------------------
 * - Nesne oluşturma mantığını merkezi bir yerde toplar
 * - İstemci kodu, somut sınıfları (new Sedan()) bilmek zorunda kalmaz
 * - Sadece tip adı söylenir, fabrika karar verir
 * 
 * NEDEN FACTORY KULLANIYORUZ?
 * ---------------------------------------------------------------------
 * 1. LOOSE COUPLING (Gevşek Bağlılık):
 *    - Main sınıfı Sedan, SUV sınıflarını import etmek zorunda kalmaz
 *    - Sadece Rentable arayüzünü bilir
 * 
 * 2. OPEN/CLOSED PRİNCİPLE (SOLID):
 *    - Yeni araç tipi eklemek için sadece fabrikaya case eklenir
 *    - Mevcut kod değişmez
 * 
 * 3. MERKEZI KONTROL:
 *    - Tüm araç oluşturma tek noktadan yönetilir
 *    - Varsayılan değerler buradan belirlenir
 * 
 * KULLANIM ÖRNEĞİ:
 * ---------------------------------------------------------------------
 * FleetHub factory = new FleetHub();
 * Rentable car = factory.createVehicle("SPORT");  // Ferrari 488 Spider döner
 * 
 * @author Emre
 * @version 1.0
 */
package creational;

// Core paketteki araç sınıflarını import et
import core.*;

/**
 * Araç üretim fabrikası sınıfı
 * 
 * "FleetHub" adı, araç filosu (fleet) yönetim merkezi anlamına gelir.
 * Tüm araç üretimi bu merkezden yapılır.
 */
public class FleetHub {

    /**
     * Factory Method - Araç üretim metodu
     * 
     * String tipine göre uygun araç nesnesi oluşturur ve döndürür.
     * 
     * AVANTAJLAR:
     * 1. İstemci "new Sedan()" demez, "SEDAN" der
     * 2. Marka, model ve fiyat fabrika tarafından belirlenir
     * 3. Gelecekte yeni tipler kolayca eklenebilir
     * 
     * SWITCH-CASE YAPISI:
     * - Her case bir araç tipini temsil eder
     * - default: Bilinmeyen tip için güvenli varsayılan
     * 
     * @param type Araç tipi (SUV, SEDAN, SPORT, FAMILY, ELECTRIC)
     * @return Oluşturulan Rentable araç nesnesi
     */
    public Rentable createVehicle(String type) {
        // Tip string'ini büyük harfe çevir (case-insensitive karşılaştırma)
        switch (type.toUpperCase()) {

            // SUV tipi araç üretimi
            case "SUV":
                // Range Rover Vogue: Lüks SUV, günlük 3000 TL
                return new SUV("Range Rover", "Vogue", 3000);

            // Sedan tipi araç üretimi
            case "SEDAN":
                // Mercedes C200: Konforlu sedan, günlük 1500 TL
                return new Sedan("Mercedes", "C200", 1500);

            // Spor araç üretimi
            case "SPORT":
                // Ferrari 488 Spider: Yüksek performanslı spor araç, günlük 5000 TL
                return new SportsCar("Ferrari", "488 Spider", 5000);

            // Aile aracı (Minivan) üretimi
            case "FAMILY":
                // Volkswagen Transporter: Geniş aile aracı, günlük 1200 TL
                return new Minivan("Volkswagen", "Transporter", 1200);

            // Elektrikli araç üretimi
            case "ELECTRIC":
                // Tesla Model S: Çevre dostu elektrikli araç, günlük 2500 TL
                return new ElectricCar("Tesla", "Model S", 2500);

            // Varsayılan araç (bilinmeyen tip için)
            default:
                // Fiat Egea: Ekonomik sedan, günlük 800 TL
                // Tanınmayan tip girildiğinde güvenli bir varsayılan
                return new Sedan("Fiat", "Egea", 800);
        }
    }
}
