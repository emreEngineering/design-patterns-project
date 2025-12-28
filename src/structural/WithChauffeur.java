/**
 * =====================================================================
 *                   CHAUFFEUR DECORATOR (WithChauffeur)
 *                    (Özel Şoför Eklentisi)
 * =====================================================================
 * 
 * Bu sınıf, araca özel şoför hizmeti ekleyen bir decorator'dır.
 * VIP müşteriler için ideal bir eklentidir.
 * 
 * ŞOFÖR HİZMETİNİN SAĞLADIĞI DEĞER:
 * ---------------------------------------------------------------------
 * - Profesyonel sürücü
 * - Konforlu yolculuk (müşteri dinlenebilir)
 * - Kurumsal toplantılara uygun
 * - Günlük ücrete +500 TL ekler (en pahalı eklenti)
 * 
 * KULLANIM SENARYOSU:
 * ---------------------------------------------------------------------
 * VIP iş adamı Elon Musk için:
 * Rentable car = factory.createVehicle("ELECTRIC");  // Tesla: 2500 TL
 * car = new WithChauffeur(car);  // Tesla + Şoför: 3000 TL
 * car = new WithGPS(car);        // Tesla + Şoför + GPS: 3050 TL
 * 
 * @author Emre
 * @version 1.0
 */
package structural;

import core.Rentable;

/**
 * Özel şoför hizmeti dekoratörü
 * 
 * Premium hizmet olduğu için en yüksek eklenti ücretine sahiptir.
 */
public class WithChauffeur extends CarDecorator {

    /**
     * WithChauffeur Constructor
     * 
     * Şoför eklenecek aracı parametre olarak alır.
     * 
     * @param car Şoför hizmeti eklenecek Rentable araç
     */
    public WithChauffeur(Rentable car) {
        super(car); // Üst sınıfa aracı ilet
    }

    /**
     * Araç detayına şoför bilgisini ekler
     * 
     * "Private Chauffeur": Özel şoför anlamına gelir
     * 
     * @return Orijinal detay + " + Private Chauffeur"
     */
    @Override
    public String getDetails() {
        return super.getDetails() + " + Private Chauffeur";
    }

    /**
     * Araç ücretine şoför ücretini ekler
     * 
     * + 500: Şoför hizmeti ücreti (TL/gün)
     * En yüksek eklenti ücreti (premium hizmet)
     * 
     * @return Orijinal ücret + 500 TL
     */
    @Override
    public double getCost() {
        return super.getCost() + 500; // Şoför ücreti: Günlük 500 TL
    }
}
