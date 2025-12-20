package structural;

import core.Rentable;

/*
 * ==============================================================================
 *                   CONCRETE DECORATOR - WithGPS
 *                  GPS Navigasyon Özelliği Dekoratörü
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * Herhangi bir Rentable nesnesine (araç veya başka decorator) GPS özelliği ekler.
 * 
 * DECORATOR CHAIN (Dekoratör Zinciri) ÖRNEĞİ:
 * -------------------------------------------
 * 
 *   // 1. Temel araç
 *   Rentable car = new Sedan("Toyota", "Corolla", 1200);
 *   
 *   // 2. GPS ekle (araba GPS ile sarılır)
 *   car = new WithGPS(car);
 *   
 *   // 3. Çocuk koltuğu da ekle (GPS'li araba, çocuk koltuğu ile sarılır)
 *   car = new WithChildSeat(car);
 *   
 *   // Şimdi nesne yapısı şöyle:
 *   //   ┌──────────────────────────────────────┐
 *   //   │          WithChildSeat               │
 *   //   │  ┌────────────────────────────────┐  │
 *   //   │  │           WithGPS              │  │
 *   //   │  │  ┌──────────────────────────┐  │  │
 *   //   │  │  │         Sedan            │  │  │
 *   //   │  │  │ (Toyota Corolla, 1200TL) │  │  │
 *   //   │  │  └──────────────────────────┘  │  │
 *   //   │  └────────────────────────────────┘  │
 *   //   └──────────────────────────────────────┘
 *   
 *   car.getDetails(); 
 *   // "[Sedan] Toyota Corolla (Comfort Edition) + GPS Navigasyonu + Çocuk Koltuğu"
 *   
 *   car.getCost();
 *   // 1200 + 50 + 100 = 1350 TL
 * 
 * ÖNEMLİ KONSEPTLER:
 * ------------------
 * - super.getDetails(): Bir önceki katmanın detaylarını alır
 * - super.getCost(): Bir önceki katmanın fiyatını alır
 * - Her decorator kendi katkısını ekler
 */
public class WithGPS extends FeatureAddon {

    /**
     * WithGPS Constructor
     * 
     * @param baseCar GPS özelliği eklenecek araç (veya decorator zinciri)
     *                Bu parametre Rentable tipinde olduğu için:
     *                - Sedan, SUV, SportsCar olabilir
     *                - WithChildSeat gibi başka bir decorator da olabilir
     */
    public WithGPS(Rentable baseCar) {
        super(baseCar); // FeatureAddon constructor'ını çağır
    }

    /**
     * GPS özelliği ile zenginleştirilmiş detay bilgisi.
     * 
     * ÇALIŞMA AKIŞI:
     * --------------
     * 1. super.getDetails() çağrılır -> "[Sedan] Toyota Corolla (Comfort Edition)"
     * 2. " + GPS Navigasyonu" eklenir
     * 3. Sonuç: "[Sedan] Toyota Corolla (Comfort Edition) + GPS Navigasyonu"
     * 
     * @return GPS eklenmiş araç detayı
     */
    @Override
    public String getDetails() {
        // Önce sarılı nesnenin detaylarını al, sonra GPS ekle
        return super.getDetails() + " + GPS Navigasyonu";
    }

    /**
     * GPS özelliği ile artırılmış fiyat.
     * GPS eklemek günlük 50 TL ek ücret.
     * 
     * ÇALIŞMA AKIŞI:
     * --------------
     * 1. super.getCost() çağrılır -> 1200 (Sedan fiyatı)
     * 2. 50 TL eklenir
     * 3. Sonuç: 1250 TL
     * 
     * @return GPS dahil günlük ücret
     */
    @Override
    public double getCost() {
        // Önce sarılı nesnenin fiyatını al, sonra GPS ücretini ekle
        return super.getCost() + 50;
    }
}
