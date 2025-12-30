/**
 * =====================================================================
 *               WINTER TIRES DECORATOR (WithWinterTires)
 *                    (Kış Lastiği Eklentisi)
 * =====================================================================
 * 
 * Bu sınıf, araca kış lastiği ekleyen bir decorator'dır.
 * Kış aylarında veya karlı bölgelerde güvenli sürüş için gereklidir.
 * 
 * KIŞ LASTİĞİNİN SAĞLADIĞI DEĞER:
 * ---------------------------------------------------------------------
 * - Kar ve buzda güvenli sürüş
 * - Yasal zorunluluklara uyum (bazı bölgelerde zorunlu)
 * - Kış tatili için ideal
 * - Günlük ücrete +80 TL ekler
 * 
 * KULLANIM SENARYOSU:
 * ---------------------------------------------------------------------
 * Uludağ kayak tatili için:
 * Rentable car = factory.createVehicle("FAMILY");  // Minivan: 1200 TL
 * car = new WithChildSeat(car);    // +100 TL
 * car = new WithWinterTires(car);  // +80 TL
 * // Toplam: 1380 TL/gün
 * 
 * @author Emre
 * @version 1.0
 */
package structural;

import core.Rentable;

/**
 * Kış lastiği dekoratörü
 * 
 * Mevsimsel güvenlik odaklı bir eklentidir.
 * Özellikle aile araçları ve SUV'larla kullanılır.
 */
public class WithWinterTires extends CarDecorator {

    /**
     * WithWinterTires Constructor
     * 
     * Kış lastiği eklenecek aracı parametre olarak alır.
     * 
     * @param car Kış lastiği eklenecek Rentable araç
     */
    public WithWinterTires(Rentable car) {
        super(car); // Üst sınıfa aracı ilet
    }

    /**
     * Araç detayına kış lastiği bilgisini ekler
     * 
     * "Winter Tires": Kış lastikleri anlamına gelir
     * 
     * @return Orijinal detay + " + Winter Tires"
     */
    @Override
    public String getDetails() {
        return super.getDetails() + " + Kış Lastikleri";
    }

    /**
     * Araç ücretine kış lastiği ücretini ekler
     * 
     * + 80: Kış lastiği ücreti (TL/gün)
     * 
     * @return Orijinal ücret + 80 TL
     */
    @Override
    public double getCost() {
        return super.getCost() + 80; // Kış lastiği: Günlük 80 TL
    }
}
