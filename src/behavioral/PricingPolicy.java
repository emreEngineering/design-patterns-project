package behavioral;

/*
 * ==============================================================================
 *                   STRATEGY DESIGN PATTERN - PricingPolicy
 *                        (Strateji Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  STRATEGY PATTERN NEDİR?                                                   ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Algoritmaları birbirleriyle DEĞİŞTİRİLEBİLİR hale getiren desendir.       ║
 * ║  Çalışma zamanında farklı algoritmalar seçilebilir.                        ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM (Strategy Olmadan):
 * ---------------------------
 * Fiyat hesaplama mantığını if-else ile yazarsak:
 * 
 *   double calculatePrice(double rawPrice, String season) {
 *       if (season.equals("yaz")) {
 *           return rawPrice * 1.3;  // Yaz: %30 zam
 *       } else if (season.equals("kış")) {
 *           return rawPrice * 0.7;  // Kış: %30 indirim
 *       } else if (season.equals("bayram")) {
 *           return rawPrice * 0.5;  // Bayram: %50 indirim
 *       } else if (season.equals("black_friday")) {
 *           return rawPrice * 0.6;  // Black Friday: %40 indirim
 *       } else {
 *           return rawPrice;        // Normal fiyat
 *       }
 *   }
 * 
 * SORUNLAR:
 * - if-else zinciri büyüdükçe karmaşıklaşır
 * - Her yeni kampanya için mevcut kodu değiştirmek gerekir
 * - Open/Closed prensibini ihlal eder
 * - Test etmesi zor
 * 
 * ÇÖZÜM (Strategy ile):
 * ---------------------
 *   PricingPolicy policy = new SeasonalDiscount(); // veya StandardRate
 *   double finalPrice = policy.calculate(1000);     // 800 TL
 *   
 *   // Çalışma anında strateji değiştirilebilir:
 *   policy = new StandardRate();
 *   double normalPrice = policy.calculate(1000);    // 1000 TL
 * 
 * STRATEGY PATTERN YAPISI:
 * ------------------------
 *                    ┌─────────────────────┐
 *                    │   PricingPolicy     │ ← Strategy Interface
 *                    │    (Interface)      │
 *                    └──────────┬──────────┘
 *                               │
 *              ┌────────────────┼────────────────┐
 *              │                │                │
 *              ▼                ▼                ▼
 *   ┌──────────────────┐ ┌──────────────────┐ ┌───────────────────┐
 *   │  StandardRate    │ │ SeasonalDiscount │ │ (Future Strategy) │
 *   │ (Concrete)       │ │   (Concrete)     │ │   BlackFriday     │
 *   └──────────────────┘ └──────────────────┘ └───────────────────┘
 *        %0 değişim          -%20 indirim
 */
public interface PricingPolicy {

    /**
     * Fiyat hesaplama metodu.
     * Her somut strateji bu metodu kendi algoritmasıyla implement eder.
     * 
     * @param rawPrice Ham fiyat (indirim öncesi)
     * @return Hesaplanmış fiyat (strateji uygulanmış)
     * 
     *         KULLANIM ÖRNEĞİ:
     *         ----------------
     *         PricingPolicy policy = new SeasonalDiscount();
     *         double finalPrice = policy.calculate(5000); // 4000 TL (%20 indirim)
     */
    double calculate(double rawPrice);
}
