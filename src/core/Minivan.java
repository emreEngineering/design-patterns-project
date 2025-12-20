package core;

/*
 * ==============================================================================
 *                             MINIVAN SINIFI
 *                     Aile Aracı - 7 Kişilik Geniş Araç
 * ==============================================================================
 * 
 * MINIVAN NEDİR?
 * --------------
 * Minivan, geniş iç hacme ve çok sayıda koltuğa (genellikle 7-9) sahip
 * aile odaklı araçlardır. Uzun yolculuklar ve büyük aileler için idealdir.
 * 
 * ÖRNEKLER: Mercedes Vito, VW Transporter, Ford Transit Custom
 * 
 * FACTORY'DE KONUMU:
 * ------------------
 * FleetHub fabrikasında "Family" kategorisi olarak tanımlanmıştır:
 * 
 *   garage.getVehicle("Family"); // -> new Minivan("Mercedes", "Vito", 1800)
 * 
 * OPEN/CLOSED PRINCIPLE:
 * ----------------------
 * Bu sınıf "Open/Closed Principle" prensibini destekler:
 * - Open for extension (Genişletmeye açık): Yeni araç tipi eklenebilir
 * - Closed for modification (Değişikliğe kapalı): Mevcut kod değişmez
 * 
 * Örneğin yarın "VanLimousine" sınıfı eklemek istersek:
 * 1. Vehicle'dan yeni bir sınıf türetiriz
 * 2. FleetHub'a bir else-if ekleriz
 * 3. Mevcut Minivan, Sedan vb. kodlara DOKUNMAYIZ
 */
public class Minivan extends Vehicle {

    /**
     * Minivan Constructor
     * 
     * @param brand     Marka (örn: "Mercedes", "VW", "Ford")
     * @param model     Model (örn: "Vito", "Transporter", "Transit")
     * @param dailyRate Günlük ücret (TL)
     */
    public Minivan(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    /**
     * Minivan'a özel detay formatı.
     * "[Van]" etiketi ve "(7 Seats - Family)" özelliği eklenir.
     * 
     * @return Minivan formatında araç bilgisi
     */
    @Override
    public String getDetails() {
        return "[Van] " + super.getDetails() + " (7 Seats - Family)";
    }
}
