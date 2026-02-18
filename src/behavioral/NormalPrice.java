/**
 * =====================================================================
 *                 NORMAL PRICE - STRATEGY IMPLEMENTASYONU
 *                    (Normal Fiyat Stratejisi)
 * =====================================================================
 * 
 * Bu sınıf, PricingPolicy arayüzünün "indirim yok" implementasyonudur.
 * Standart müşteriler için kullanılır - fiyat olduğu gibi kalır.
 * 
 * KULLANIM SENARYOSU:
 * ---------------------------------------------------------------------
 * - Standart/normal müşteriler
 * - Kampanya dönemi dışı
 * - Bilinmeyen müşteri tipi (varsayılan)
 * 
 * @author Emre
 * @version 1.0
 */
package behavioral;

/**
 * Normal fiyat stratejisi - İndirim uygulanmaz
 * 
 * En basit strateji implementasyonu.
 * Fiyatı olduğu gibi döndürür.
 */
public class NormalPrice implements PricingPolicy {

    /**
     * Normal fiyat hesaplama
     * 
     * İndirim uygulamaz, fiyatı olduğu gibi döndürür.
     * Bu, "Null Object Pattern"e benzer bir yaklaşımdır.
     * 
     * @param price Temel fiyat
     * @return Aynı fiyat (değişiklik yok)
     */
    public double calculate(double price) {
        // İndirim yok, fiyat aynen kalır
        return price;
    }
}
