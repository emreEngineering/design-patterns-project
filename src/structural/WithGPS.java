/**
 * =====================================================================
 *                      GPS DECORATOR (WithGPS)
 *                    (GPS Navigasyon Eklentisi)
 * =====================================================================
 * 
 * Bu sınıf, araca GPS navigasyon sistemi ekleyen bir decorator'dır.
 * CarDecorator soyut sınıfını extend eder.
 * 
 * GPS'İN SAĞLADIĞI DEĞER:
 * ---------------------------------------------------------------------
 * - Yol tarifi ve navigasyon
 * - Trafik bilgisi
 * - Yakın mekan önerileri
 * - Günlük ücrete +50 TL ekler
 * 
 * KULLANIM ÖRNEĞİ:
 * ---------------------------------------------------------------------
 * Rentable car = factory.createVehicle("ELECTRIC");  // Tesla: 2500 TL
 * car = new WithGPS(car);  // Tesla + GPS: 2500 + 50 = 2550 TL
 * 
 * car.getDetails();  // "[EV] Tesla Model S (Eco-Friendly) + GPS"
 * car.getCost();     // 2550.0
 * 
 * @author Emre
 * @version 1.0
 */
package structural;

import core.Rentable;

/**
 * GPS navigasyon eklentisi dekoratörü
 */
public class WithGPS extends CarDecorator {

    /**
     * WithGPS Constructor
     * 
     * GPS eklenecek aracı parametre olarak alır.
     * super(car) ile üst sınıfın (CarDecorator) yapıcısını çağırır.
     * 
     * @param car GPS eklenecek Rentable araç
     */
    public WithGPS(Rentable car) {
        super(car); // Üst sınıfa aracı ilet, tempCar'a atansın
    }

    /**
     * Araç detayına GPS bilgisini ekler
     * 
     * super.getDetails(): Sarmalanan aracın detayını alır
     * " + GPS": GPS eklentisini belirten suffix
     * 
     * @return Orijinal detay + " + GPS"
     */
    @Override
    public String getDetails() {
        return super.getDetails() + " + GPS";
    }

    /**
     * Araç ücretine GPS ücretini ekler
     * 
     * super.getCost(): Sarmalanan aracın ücretini alır
     * + 50: GPS eklenti ücreti (TL/gün)
     * 
     * @return Orijinal ücret + 50 TL
     */
    @Override
    public double getCost() {
        return super.getCost() + 50; // GPS ücreti: Günlük 50 TL
    }
}
