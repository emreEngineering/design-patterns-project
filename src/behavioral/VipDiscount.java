/**
 * =====================================================================
 *                 VIP DISCOUNT - STRATEGY IMPLEMENTASYONU
 *                    (VIP Kurumsal İndirim Stratejisi)
 * =====================================================================
 * 
 * Bu sınıf, PricingPolicy arayüzünün "%30 indirim" implementasyonudur.
 * VIP ve kurumsal müşteriler için premium indirim sağlar.
 * 
 * KULLANIM SENARYOSU:
 * ---------------------------------------------------------------------
 * - Kurumsal anlaşmalı firmalar
 * - Sık kiralama yapan sadık müşteriler
 * - VIP üyelik programı katılımcıları
 * 
 * İNDİRİM ORANI: %30 (fiyat x 0.7)
 * 
 * @author Emre
 * @version 1.0
 */
package behavioral;

/**
 * VIP indirim stratejisi - %30 kurumsal indirim
 * 
 * En yüksek indirim oranına sahip strateji.
 * Sadık ve kurumsal müşterileri ödüllendirir.
 */
public class VipDiscount implements PricingPolicy {

    /**
     * VIP indirimli fiyat hesaplama
     * 
     * Fiyata %30 indirim uygular.
     * Hesaplama: fiyat × 0.7 = indirimli fiyat
     * 
     * Örnek:
     * - Giriş: 1000 TL
     * - Çıkış: 700 TL (%30 indirim)
     * 
     * @param price Temel fiyat
     * @return %30 indirimli fiyat
     */
    public double calculate(double price) {
        // Konsola indirim bilgisi yazdır
        System.out.println("[Strategy] VIP Corporate Discount applied (-30%)");

        // %30 indirim: fiyat × 0.7
        // (1 - 0.30 = 0.70 = %70'ini öde)
        return price * 0.7;
    }
}
