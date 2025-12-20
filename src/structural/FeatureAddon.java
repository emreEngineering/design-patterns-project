package structural;

import core.Rentable;

/*
 * ==============================================================================
 *                   DECORATOR DESIGN PATTERN - FeatureAddon
 *                        (Dekoratör Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  DECORATOR PATTERN NEDİR?                                                  ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Nesnelere ÇALIŞMA ZAMANINDA yeni özellikler eklemeyi sağlayan desendir.   ║
 * ║  Miras almadan (inheritance) genişletme yapar.                             ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM (Decorator Olmadan - Class Explosion):
 * -----------------------------------------------
 * Araçlara GPS, Çocuk Koltuğu, Sunroof eklemek istiyoruz.
 * Miras alma ile yaparsak:
 * 
 *   CarWithGPS
 *   CarWithChildSeat
 *   CarWithSunroof
 *   CarWithGPSAndChildSeat
 *   CarWithGPSAndSunroof
 *   CarWithChildSeatAndSunroof
 *   CarWithGPSAndChildSeatAndSunroof
 *   ... (Kombinasyon patlaması!)
 * 
 * 3 özellik = 7 sınıf, 10 özellik = 1023 sınıf!
 * 
 * ÇÖZÜM (Decorator ile - Composition):
 * ------------------------------------
 * Nesneleri "paketleyerek" (wrapping) özellik ekliyoruz:
 * 
 *   Rentable car = new Sedan("Toyota", "Corolla", 1200);
 *   car = new WithGPS(car);        // GPS ekle
 *   car = new WithChildSeat(car);  // Çocuk koltuğu ekle
 *   
 *   car.getDetails(); // "[Sedan] Toyota Corolla + GPS + Çocuk Koltuğu"
 *   car.getCost();    // 1200 + 50 + 100 = 1350
 * 
 * DECORATOR PATTERN YAPISINI GÖRSEL:
 * ----------------------------------
 * 
 *                      ┌───────────────┐
 *                      │   Rentable    │ (Interface)
 *                      └───────┬───────┘
 *                              │
 *         ┌────────────────────┼────────────────────┐
 *         │                    │                    │
 *         ▼                    ▼                    ▼
 *   ┌───────────┐      ┌─────────────┐      ┌─────────────┐
 *   │  Vehicle  │      │ FeatureAddon│      │  WithGPS    │
 *   │ (Abstract)│      │ (Abstract)  │      │(Concrete)   │
 *   └───────────┘      └─────────────┘      └─────────────┘
 *                              │                    │
 *                              └────────────────────┘
 *                                 "Has-a" ilişkisi
 *                          (içinde bir Rentable tutar)
 * 
 * NEDEN ABSTRACT SINIF?
 * ---------------------
 * Bu sınıf abstract çünkü:
 * 1. Ortak davranışı tanımlar (baseCar tutma, delegation)
 * 2. Somut decorator'lar bunu genişletir (WithGPS, WithChildSeat)
 * 3. Doğrudan new FeatureAddon() yapmak mantıksız
 */
abstract class FeatureAddon implements Rentable {

    /**
     * WRAPPED OBJECT (Sarılmış/Dekore Edilmiş Nesne)
     * -----------------------------------------------
     * Bu değişken, üzerine özellik eklediğimiz temel nesneyi tutar.
     * "protected" olduğu için alt sınıflar (WithGPS vb.) erişebilir.
     * 
     * Örnek:
     * baseCar = new Sedan("Toyota", "Corolla", 1200);
     * // veya
     * baseCar = new WithGPS(sedan); // Decorator da Rentable olduğu için!
     */
    protected Rentable baseCar;

    /**
     * Constructor - Dekore edilecek nesneyi alır
     * 
     * @param baseCar Özellik eklenecek temel araç (veya decorator)
     */
    public FeatureAddon(Rentable baseCar) {
        this.baseCar = baseCar;
    }

    /**
     * DELEGATION (Yetki Devri)
     * ------------------------
     * Varsayılan davranış: Sarılı nesnenin detaylarını döndür.
     * Alt sınıflar bu metodu override ederek kendi özelliklerini ekler.
     * 
     * @return Temel aracın detayları
     */
    public String getDetails() {
        return baseCar.getDetails();
    }

    /**
     * DELEGATION (Yetki Devri)
     * ------------------------
     * Varsayılan davranış: Sarılı nesnenin fiyatını döndür.
     * Alt sınıflar bu metodu override ederek ek ücret ekler.
     * 
     * @return Temel aracın fiyatı
     */
    public double getCost() {
        return baseCar.getCost();
    }
}
