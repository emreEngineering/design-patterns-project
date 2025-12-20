package core;

/*
 * ==============================================================================
 *                            SPORTSCAR SINIFI
 *                    Lüks Spor Otomobil - Yüksek Performans
 * ==============================================================================
 * 
 * SPORTSCAR NEDİR?
 * -----------------
 * Spor arabalar, yüksek hız, güçlü motor ve aerodinamik tasarıma sahip
 * performans odaklı araçlardır.
 * 
 * ÖRNEKLER: Porsche 911, Ferrari, Lamborghini
 * 
 * FİYATLANDIRMA NOTU:
 * -------------------
 * Spor arabalar en pahalı kategoridir (5000 TL/gün).
 * Factory'de "Luxury" kategorisi olarak tanımlanmıştır.
 * 
 * POLYMORPHISM ÖRNEĞİ:
 * --------------------
 * Aşağıdaki kodda her iki değişken de Rentable tipindedir ama
 * farklı sınıflardan nesne tutar:
 * 
 *   Rentable car1 = new Sedan("Fiat", "Egea", 800);
 *   Rentable car2 = new SportsCar("Porsche", "911", 5000);
 *   
 *   car1.getDetails(); // "[Sedan] Fiat Egea (Comfort Edition)"
 *   car2.getDetails(); // "[Sport] Porsche 911 (High Performance)"
 * 
 * Bu "polymorphism" (çok biçimlilik) sayesinde aynı metod çağrısı
 * farklı sonuçlar üretir.
 */
public class SportsCar extends Vehicle {

    /**
     * SportsCar Constructor
     * 
     * @param brand     Marka (örn: "Porsche", "Ferrari", "Lamborghini")
     * @param model     Model (örn: "911 Carrera", "488", "Huracan")
     * @param dailyRate Günlük ücret (TL) - En yüksek fiyat kategorisi
     */
    public SportsCar(String brand, String model, double dailyRate) {
        super(brand, model, dailyRate);
    }

    /**
     * Spor arabaya özel detay formatı.
     * "[Sport]" etiketi ve "(High Performance)" özelliği eklenir.
     * 
     * @return Spor araba formatında araç bilgisi
     */
    @Override
    public String getDetails() {
        return "[Sport] " + super.getDetails() + " (High Performance)";
    }
}
