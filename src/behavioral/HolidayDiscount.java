/**
 * =====================================================================
 *              HOLIDAY DISCOUNT - STRATEGY IMPLEMENTASYONU
 *                    (Tatil/Sezon İndirimi Stratejisi)
 * =====================================================================
 * 
 * Bu sınıf, PricingPolicy arayüzünün "%20 indirim" implementasyonudur.
 * Tatil dönemlerinde müşterileri teşvik etmek için kullanılır.
 * 
 * KULLANIM SENARYOSU:
 * ---------------------------------------------------------------------
 * - Yaz tatili dönemi
 * - Bayram kampanyaları
 * - Kış tatili (kayak sezonu)
 * - Özel gün promosyonları
 * 
 * İNDİRİM ORANI: %20 (fiyat x 0.8)
 * 
 * @author Emre
 * @version 1.0
 */
package behavioral;

/**
 * Tatil indirimi stratejisi - %20 sezonluk indirim
 * 
 * Orta seviye indirim.
 * Tatil döneminde kiralama sayısını artırmak için kullanılır.
 */
public class HolidayDiscount implements PricingPolicy {

    /**
     * Tatil indirimli fiyat hesaplama
     * 
     * Fiyata %20 indirim uygular.
     * Hesaplama: fiyat × 0.8 = indirimli fiyat
     * 
     * Örnek:
     * - Giriş: 1000 TL
     * - Çıkış: 800 TL (%20 indirim)
     * 
     * @param price Temel fiyat
     * @return %20 indirimli fiyat
     */
    public double calculate(double price) {
        // Konsola indirim bilgisi yazdır
        System.out.println("[Strategy] Holiday Discount applied (-20%)");

        // %20 indirim: fiyat × 0.8
        // (1 - 0.20 = 0.80 = %80'ini öde)
        return price * 0.8;
    }
}
