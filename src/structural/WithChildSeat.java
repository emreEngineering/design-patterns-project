/**
 * =====================================================================
 *                  CHILD SEAT DECORATOR (WithChildSeat)
 *                    (Bebek/Çocuk Koltuğu Eklentisi)
 * =====================================================================
 * 
 * Bu sınıf, araca bebek/çocuk koltuğu ekleyen bir decorator'dır.
 * Aile müşterileri için güvenlik açısından kritik bir eklentidir.
 * 
 * ÇOCUK KOLTUĞUNUN SAĞLADIĞI DEĞER:
 * ---------------------------------------------------------------------
 * - Çocuklar için güvenli yolculuk
 * - Yasal zorunluluklara uyum
 * - Aile dostu hizmet
 * - Günlük ücrete +100 TL ekler
 * 
 * KULLANIM SENARYOSU:
 * ---------------------------------------------------------------------
 * Aile tatili için:
 * Rentable car = factory.createVehicle("FAMILY");  // Minivan: 1200 TL
 * car = new WithChildSeat(car);   // Minivan + Koltuk: 1300 TL
 * car = new WithWinterTires(car); // Minivan + Koltuk + Lastik: 1380 TL
 * 
 * @author Emre
 * @version 1.0
 */
package structural;

import core.Rentable;

/**
 * Bebek/Çocuk koltuğu dekoratörü
 * 
 * Aile odaklı hizmetler için tasarlanmıştır.
 * Genellikle Minivan tipindeki araçlarla birlikte kullanılır.
 */
public class WithChildSeat extends CarDecorator {

    /**
     * WithChildSeat Constructor
     * 
     * Çocuk koltuğu eklenecek aracı parametre olarak alır.
     * 
     * @param car Çocuk koltuğu eklenecek Rentable araç
     */
    public WithChildSeat(Rentable car) {
        super(car); // Üst sınıfa aracı ilet
    }

    /**
     * Araç detayına çocuk koltuğu bilgisini ekler
     * 
     * "Baby Seat": Bebek koltuğu anlamına gelir
     * 
     * @return Orijinal detay + " + Baby Seat"
     */
    @Override
    public String getDetails() {
        return super.getDetails() + " + Bebek Koltuğu";
    }

    /**
     * Araç ücretine çocuk koltuğu ücretini ekler
     * 
     * + 100: Çocuk koltuğu ücreti (TL/gün)
     * 
     * @return Orijinal ücret + 100 TL
     */
    @Override
    public double getCost() {
        return super.getCost() + 100; // Çocuk koltuğu: Günlük 100 TL
    }
}
