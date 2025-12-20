package structural;

import core.Rentable;

/*
 * ==============================================================================
 *                   CONCRETE DECORATOR - WithChildSeat
 *                    Çocuk Koltuğu Özelliği Dekoratörü
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * Herhangi bir Rentable nesnesine çocuk koltuğu özelliği ekler.
 * WithGPS ile aynı mantıkta çalışır.
 * 
 * FARKLI KOMBİNASYON ÖRNEKLARI:
 * -----------------------------
 * 
 *   // Sadece çocuk koltuğu
 *   Rentable car1 = new WithChildSeat(new Sedan(...));
 *   
 *   // GPS + Çocuk Koltuğu
 *   Rentable car2 = new WithChildSeat(new WithGPS(new Sedan(...)));
 *   
 *   // Çocuk Koltuğu + GPS (sıra farklı, sonuç aynı)
 *   Rentable car3 = new WithGPS(new WithChildSeat(new Sedan(...)));
 *   
 *   // SUV + GPS + Çocuk Koltuğu
 *   Rentable car4 = new WithChildSeat(new WithGPS(new SUV(...)));
 * 
 * DECORATOR vs INHERITANCE:
 * -------------------------
 * Inheritance: Derleme zamanında belirlenir, sabit
 * Decorator: Çalışma zamanında belirlenir, esnek
 * 
 * Inheritance ile "GPS'li Sedan" ve "Çocuk Koltuklu SUV" için
 * 2 ayrı sınıf lazım. Decorator ile tek sınıf her yere uygulanabilir!
 */
public class WithChildSeat extends FeatureAddon {

    /**
     * WithChildSeat Constructor
     * 
     * @param baseCar Çocuk koltuğu eklenecek araç veya decorator zinciri
     */
    public WithChildSeat(Rentable baseCar) {
        super(baseCar);
    }

    /**
     * Çocuk koltuğu özelliği ile zenginleştirilmiş detay bilgisi.
     * 
     * @return Çocuk koltuğu eklenmiş araç detayı
     */
    @Override
    public String getDetails() {
        return super.getDetails() + " + Çocuk Koltuğu";
    }

    /**
     * Çocuk koltuğu özelliği ile artırılmış fiyat.
     * Çocuk koltuğu günlük 100 TL ek ücret (GPS'ten daha pahalı).
     * 
     * @return Çocuk koltuğu dahil günlük ücret
     */
    @Override
    public double getCost() {
        return super.getCost() + 100;
    }
}
