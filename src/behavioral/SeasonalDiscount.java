package behavioral;

/*
 * ==============================================================================
 *                   CONCRETE STRATEGY - SeasonalDiscount
 *                      Mevsimlik İndirim Stratejisi
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * Fiyata %20 indirim uygular (0.8 çarpanı).
 * Yaz sezonu, bayram kampanyası gibi dönemlerde kullanılır.
 * 
 * STRATEGY PATTERN'İN GÜCÜ:
 * -------------------------
 * Yeni bir kampanya (örn: Black Friday %40 indirim) eklemek için:
 * 
 *   1. Yeni sınıf oluştur:
 *      class BlackFriday implements PricingPolicy {
 *          public double calculate(double rawPrice) {
 *              return rawPrice * 0.6;  // %40 indirim
 *          }
 *      }
 *   
 *   2. Kullan:
 *      PricingPolicy policy = new BlackFriday();
 *      double price = policy.calculate(1000);  // 600 TL
 * 
 * - Mevcut kodlara DOKUNMADIN!
 * - Open/Closed prensibine uydun!
 * 
 * ÖRNEK KULLANIM:
 * ---------------
 *   PricingPolicy policy = new SeasonalDiscount();
 *   double price = policy.calculate(5000);  // 4000 TL (%20 indirim)
 */
public class SeasonalDiscount implements PricingPolicy {

    /**
     * %20 mevsimlik indirim uygular.
     * 
     * @param rawPrice Orijinal fiyat
     * @return İndirimli fiyat (rawPrice * 0.8)
     */
    public double calculate(double rawPrice) {
        System.out.println("[Pricing] Mevsimlik İndirim Uygulandı (-20%)");

        // %20 indirim = fiyatın %80'i
        // 5000 * 0.8 = 4000 TL
        return rawPrice * 0.8;
    }
}
