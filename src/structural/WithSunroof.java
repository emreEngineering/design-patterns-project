/**
 * =====================================================================
 *                  SUNROOF DECORATOR (WithSunroof)
 *                    (Açılır Tavan Eklentisi)
 * =====================================================================
 * 
 * Bu sınıf, araca açılır tavan (sunroof) özelliği ekleyen bir decorator'dır.
 * Özellikle spor araçlar ve romantik sürüşler için tercih edilir.
 * 
 * SUNROOF'UN SAĞLADIĞI DEĞER:
 * ---------------------------------------------------------------------
 * - Açık hava sürüş deneyimi
 * - Kabin içine doğal ışık
 * - Premium görünüm
 * - Günlük ücrete +150 TL ekler
 * 
 * KULLANIM SENARYOSU:
 * ---------------------------------------------------------------------
 * Genç çift için romantik hafta sonu:
 * Rentable car = factory.createVehicle("SPORT");  // Ferrari: 5000 TL
 * car = new WithSunroof(car);  // Ferrari + Sunroof: 5150 TL
 * 
 * @author Emre
 * @version 1.0
 */
package structural;

import core.Rentable;

/**
 * Açılır tavan (sunroof) dekoratörü
 * 
 * Estetik ve konfor odaklı bir eklentidir.
 * Genellikle SportsCar tipindeki araçlarla birlikte kullanılır.
 */
public class WithSunroof extends CarDecorator {

    /**
     * WithSunroof Constructor
     * 
     * Sunroof eklenecek aracı parametre olarak alır.
     * 
     * @param car Sunroof eklenecek Rentable araç
     */
    public WithSunroof(Rentable car) {
        super(car); // Üst sınıfa aracı ilet
    }

    /**
     * Araç detayına sunroof bilgisini ekler
     * 
     * @return Orijinal detay + " + Sunroof"
     */
    @Override
    public String getDetails() {
        return super.getDetails() + " + Açılır Tavan";
    }

    /**
     * Araç ücretine sunroof ücretini ekler
     * 
     * + 150: Sunroof ücreti (TL/gün)
     * 
     * @return Orijinal ücret + 150 TL
     */
    @Override
    public double getCost() {
        return super.getCost() + 150; // Sunroof: Günlük 150 TL
    }
}
