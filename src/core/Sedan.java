package core;

/*
 * ==============================================================================
 *                              SEDAN SINIFI
 *                  Konfor Odaklı Standart Araç (Economy/Comfort)
 * ==============================================================================
 * 
 * SEDAN NEDİR?
 * ------------
 * Sedan, 4 kapılı, bagaj bölümü ayrı olan standart otomobildir.
 * Şehir içi kullanım ve konfor için idealdi.
 * 
 * INHERITANCE (KALITIM) ÖRNEĞİ:
 * -----------------------------
 * Bu sınıf Vehicle'dan miras alır (extends). Bu sayede:
 * - Vehicle'daki tüm alanları (brand, model, dailyRate) otomatik alır
 * - Vehicle'daki metodları kullanabilir veya override edebilir
 * - Kendi özel davranışlarını ekleyebilir
 * 
 * super() ANAHTAR KELİMESİ:
 * -------------------------
 * Constructor'da super(brand, model, dailyRate) çağrısı,
 * Vehicle sınıfının constructor'ını çalıştırır.
 * Bu zorunludur çünkü üst sınıfın alanları önce initialize edilmelidir.
 * 
 * KULLANIM ÖRNEĞİ:
 * ----------------
 * Rentable car = new Sedan("Toyota", "Corolla", 1200);
 * System.out.println(car.getDetails()); // [Sedan] Toyota Corolla (Comfort Edition)
 * System.out.println(car.getCost());    // 1200.0
 */
public class Sedan extends Vehicle {

    /**
     * Sedan Constructor
     * 
     * @param brand     Marka (örn: "Fiat", "Toyota", "Renault")
     * @param model     Model (örn: "Egea", "Corolla", "Clio")
     * @param dailyRate Günlük ücret (TL)
     */
    public Sedan(String brand, String model, double dailyRate) {
        // Üst sınıfın (Vehicle) constructor'ını çağır
        // Bu çağrı zorunludur ve ilk satırda olmalıdır
        super(brand, model, dailyRate);
    }

    /**
     * getDetails() metodunun OVERRIDE edilmiş hali.
     * Sedan'a özel format ekler: "[Sedan]" prefix ve "(Comfort Edition)" suffix
     * 
     * @Override annotation'ı derleyiciye "bu metod üst sınıftan geliyor" der.
     *           Eğer üst sınıfta böyle bir metod yoksa derleme hatası verir
     *           (güvenlik).
     * 
     * @return Sedan formatında araç bilgisi
     */
    @Override
    public String getDetails() {
        // super.getDetails() -> Vehicle sınıfındaki getDetails() çağrılır
        // Bu "Toyota Corolla" döner, biz başına ve sonuna ekleme yapıyoruz
        return "[Sedan] " + super.getDetails() + " (Comfort Edition)";
    }

    // NOT: getCost() metodunu override etmedik çünkü
    // Vehicle'daki varsayılan davranış (dailyRate döndürme) bizim için yeterli.
}
