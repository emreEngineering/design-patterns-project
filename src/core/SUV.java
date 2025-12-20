package core;

/*
 * ==============================================================================
 *                               SUV SINIFI
 *               Sport Utility Vehicle - Arazi ve Şehir Kullanımlı
 * ==============================================================================
 * 
 * SUV NEDİR?
 * ----------
 * SUV (Sport Utility Vehicle), yüksek şasi, 4x4 sürüş ve geniş iç hacme sahip
 * araçlardır. Hem arazi hem şehir kullanımına uygundur.
 * 
 * ÖRNEKLER: Range Rover, Land Cruiser, Jeep Wrangler
 * 
 * FACTORY PATTERN İLE BAĞLANTISI:
 * -------------------------------
 * FleetHub fabrikası "SUV" kategorisi istendiğinde bu sınıftan nesne üretir:
 * 
 *   if (category.equalsIgnoreCase("SUV")) {
 *       return new SUV("Range Rover", "Sport", 2500);
 *   }
 * 
 * Bu sayede Main sınıfı hangi somut sınıfın üretildiğini bilmez,
 * sadece "SUV" kategorisini ister ve Rentable tipinde nesne alır.
 */
public class SUV extends Vehicle {

    /**
     * SUV Constructor
     * 
     * @param brand     Marka (örn: "Range Rover", "Land Rover", "Jeep")
     * @param model     Model (örn: "Sport", "Defender", "Wrangler")
     * @param dailyRate Günlük ücret (TL) - SUV'lar genelde daha pahalıdır
     */
    public SUV(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    /**
     * SUV'a özel detay formatı.
     * "[SUV]" etiketi ve "(4x4 Off-Road)" özelliği eklenir.
     * 
     * @return SUV formatında araç bilgisi
     */
    @Override
    public String getDetails() {
        return "[SUV] " + super.getDetails() + " (4x4 Off-Road)";
    }
}
