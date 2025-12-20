package core;

/*
 * ==============================================================================
 *                              RENTABLE INTERFACE
 *                     (Kiralanabilir Arayüzü - Ortak Sözleşme)
 * ==============================================================================
 * 
 * BU ARAYÜZ NE İŞE YARAR?
 * ------------------------
 * Bu arayüz, sistemdeki TÜM kiralanabilir nesnelerin (araçlar ve eklentiler)
 * uyması gereken kuralları belirler. Java'da "interface" bir sözleşme gibidir.
 * 
 * NEDEN INTERFACE KULLANDIK?
 * --------------------------
 * 1. Polymorphism (Çok Biçimlilik): Farklı sınıfları aynı tipte işleyebiliriz.
 *    Örnek: Rentable car = new Sedan(...); veya Rentable car = new WithGPS(...);
 * 
 * 2. Loose Coupling (Gevşek Bağlılık): Kod, somut sınıflara değil arayüze bağlıdır.
 *    Bu sayede yeni araç tipleri eklemek çok kolay olur.
 * 
 * 3. Decorator Pattern Desteği: FeatureAddon sınıfları da bu arayüzü implement eder,
 *    böylece araç + eklenti kombinasyonları aynı tip olarak kullanılabilir.
 * 
 * METODLARIN AÇIKLAMASI:
 * ----------------------
 * - getDetails(): Aracın marka, model ve özellik bilgilerini String olarak döner.
 * - getCost(): Aracın günlük kiralama ücretini double olarak döner.
 */
public interface Rentable {
    
    /**
     * Aracın detaylı bilgilerini döndürür.
     * Örnek çıktı: "[Sedan] Toyota Corolla (Comfort Edition) + GPS Navigasyonu"
     * 
     * @return Araç bilgisi içeren String
     */
    String getDetails();

    /**
     * Aracın günlük kiralama ücretini döndürür.
     * Decorator pattern ile eklentiler bu ücreti artırabilir.
     * 
     * @return Günlük ücret (TL cinsinden)
     */
    double getCost();
}
