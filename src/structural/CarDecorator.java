/**
 * =====================================================================
 *                  CAR DECORATOR - DECORATOR PATTERN
 *                (Araç Süsleyici Soyut Sınıfı)
 * =====================================================================
 * 
 * Bu sınıf, DECORATOR (Süsleyici) tasarım deseninin temel sınıfıdır.
 * Araçlara dinamik olarak yeni özellikler (GPS, şoför, vb.) eklemeyi sağlar.
 * 
 * DECORATOR PATTERN NEDİR?
 * ---------------------------------------------------------------------
 * - Nesneye çalışma zamanında (runtime) yeni davranışlar ekler
 * - Kalıtım yerine kompozisyon (sarmalama) kullanır
 * - Mevcut kodu değiştirmeden fonksiyonellik genişletir
 * 
 * NEDEN KALITIM YERİNE DECORATOR?
 * ---------------------------------------------------------------------
 * Kalıtım ile: (Kötü Yaklaşım)
 *   - SedanWithGPS, SedanWithGPSAndChildSeat, SedanWithSunroof...
 *   - Her kombinasyon için yeni sınıf gerekir (sınıf patlaması!)
 * 
 * Decorator ile: (İyi Yaklaşım)
 *   - car = new WithGPS(car);
 *   - car = new WithChildSeat(car);
 *   - Dinamik kombinasyonlar, az sayıda sınıf
 * 
 * DECORATOR'UN ÇALIŞMA MANTIĞI:
 * ---------------------------------------------------------------------
 * 1. tempCar: İçinde sarmalanan (wrapped) aracı tutar
 * 2. getDetails(): Önce sarmalanan aracın detayını alır, sonra kendi eklemesini yapar
 * 3. getCost(): Önce sarmalanan aracın ücretini alır, sonra kendi ücretini ekler
 * 
 * ZİNCİRLEME SARMALAMA ÖRNEĞİ:
 * ---------------------------------------------------------------------
 * Rentable car = new Minivan("VW", "Transporter", 1200);
 * car = new WithChildSeat(car);   // Minivan'ı sarmalar
 * car = new WithGPS(car);         // WithChildSeat'i sarmalar
 * 
 * car.getCost():
 *   WithGPS.getCost() 
 *     → WithChildSeat.getCost() + 50
 *       → Minivan.getCost() + 100 + 50
 *         → 1200 + 100 + 50 = 1350 TL
 * 
 * @author Emre
 * @version 1.0
 */
package structural;

import core.Rentable; // Ortak arayüz

/**
 * Tüm dekoratörlerin türediği soyut temel sınıf
 * 
 * Rentable arayüzünü implement eder:
 * - Bu sayede dekoratör de bir Rentable'dır
 * - Dekoratör içinde dekoratör sarmalanabilir (zincirleme)
 * - Polimorfizm: İstemci kodu farkı bilmez
 */
abstract class
CarDecorator implements Rentable {

    /**
     * Sarmalanan (wrapped) araç referansı
     * 
     * protected: Alt sınıflardan (WithGPS, WithChildSeat) erişilebilir
     * 
     * Bu değişken şunları tutabilir:
     * - Temel bir araç (Sedan, SUV, Minivan)
     * - Başka bir dekoratör (WithGPS, WithChildSeat)
     * 
     * "temp" (temporary değil): Template pattern'de kullanılan geleneksel
     * isimlendirme
     */
    protected Rentable tempCar;

    /**
     * Decorator Constructor
     * 
     * Sarmalanacak aracı parametre olarak alır.
     * Alt sınıflar super(car) ile bu yapıcıyı çağırır.
     * 
     * @param car Sarmalanacak Rentable nesnesi
     */
    public CarDecorator(Rentable car) {
        this.tempCar = car; // Referansı sakla
    }

    /**
     * Sarmalanan aracın detaylarını döndürür
     * 
     * Bu varsayılan implementasyon, sarmalanan aracın detayını döndürür.
     * Alt sınıflar bu metodu override ederek kendi eklentilerini ekler.
     * 
     * Örnek:
     * - CarDecorator.getDetails() → "Mercedes C200"
     * - WithGPS.getDetails() → super.getDetails() + " + GPS" → "Mercedes C200 +
     * GPS"
     * 
     * @return Sarmalanan aracın detay string'i
     */
    public String getDetails() {
        // Delegasyon: İşi sarmalanan nesneye devret
        return tempCar.getDetails();
    }

    /**
     * Sarmalanan aracın ücretini döndürür
     * 
     * Bu varsayılan implementasyon, sarmalanan aracın ücretini döndürür.
     * Alt sınıflar bu metodu override ederek kendi ücretlerini ekler.
     * 
     * Örnek:
     * - CarDecorator.getCost() → 1500
     * - WithGPS.getCost() → super.getCost() + 50 → 1550
     * 
     * @return Sarmalanan aracın günlük ücreti
     */
    public double getCost() {
        // Delegasyon: İşi sarmalanan nesneye devret
        return tempCar.getCost();
    }
}
