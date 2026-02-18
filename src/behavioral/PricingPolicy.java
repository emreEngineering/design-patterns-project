/**
 * =====================================================================
 *                PRICING POLICY - STRATEGY PATTERN
 *                    (Fiyatlandırma Strateji Arayüzü)
 * =====================================================================
 * 
 * Bu arayüz, STRATEGY (Strateji) tasarım deseninin temelini oluşturur.
 * Farklı fiyatlandırma algoritmalarını (indirimler) birbirinin yerine
 * geçebilir şekilde tanımlar.
 * 
 * STRATEGY PATTERN NEDİR?
 * ---------------------------------------------------------------------
 * - Algoritma ailesini tanımlar ve her birini kapsüller
 * - Algoritmalar çalışma zamanında değiştirilebilir
 * - İstemci kodu, kullanılan algoritmadan bağımsızdır
 * 
 * NEDEN STRATEGY KULLANIYORUZ?
 * ---------------------------------------------------------------------
 * 1. DİNAMİK ALGORİTMA SEÇİMİ:
 *    - Normal fiyat, VIP indirimi, tatil indirimi farklı stratejiler
 *    - Müşteri tipine göre strateji seçilir
 * 
 * 2. OPEN/CLOSED PRİNCİPLE (SOLID):
 *    - Yeni indirim tipi eklemek için mevcut kod değişmez
 *    - Sadece yeni sınıf eklenir (örn: StudentDiscount)
 * 
 * 3. IF-ELSE KARIMAŞIKLIĞINI ÖNLEME:
 *    - Her strateji kendi calculate() metoduna sahip
 *    - Switch/case yerine polimorfizm kullanılır
 * 
 * MEVCUT STRATEJİLER:
 * ---------------------------------------------------------------------
 * - NormalPrice: İndirim yok, tam fiyat
 * - VipDiscount: %30 kurumsal indirim
 * - HolidayDiscount: %20 sezonluk indirim
 * 
 * @author Emre
 * @version 1.0
 */
package behavioral;

/**
 * Fiyatlandırma stratejisi arayüzü
 * 
 * Tüm fiyatlandırma stratejileri bu arayüzü implement eder.
 * Polimorfizm sayesinde strateji dinamik olarak değiştirilebilir.
 */
public interface PricingPolicy {

    /**
     * Fiyat hesaplama metodu
     * 
     * Her strateji bu metodu implement ederek kendi hesaplama
     * mantığını uygular.
     * 
     * Örnek:
     * - NormalPrice.calculate(1000) → 1000 (değişiklik yok)
     * - VipDiscount.calculate(1000) → 700 (%30 indirim)
     * - HolidayDiscount.calculate(1000) → 800 (%20 indirim)
     * 
     * @param price Temel fiyat (TL)
     * @return İndirimli/hesaplanmış fiyat (TL)
     */
    double calculate(double price);
}
