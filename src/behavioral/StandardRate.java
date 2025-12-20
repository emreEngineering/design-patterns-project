package behavioral;

/*
 * ==============================================================================
 *                   CONCRETE STRATEGY - StandardRate
 *                      Standart Fiyat Stratejisi
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * En basit strateji: Fiyata hiçbir değişiklik yapmaz.
 * Ham fiyatı olduğu gibi döndürür.
 * 
 * KULLANIM SENARYOLARI:
 * ---------------------
 * - Normal sezon (kampanya yok)
 * - Varsayılan fiyatlandırma
 * - Test amaçlı (fiyat değişimini devre dışı bırakmak için)
 * 
 * ÖRNEK:
 * ------
 *   PricingPolicy policy = new StandardRate();
 *   double price = policy.calculate(1000);  // 1000 TL (değişim yok)
 */
class StandardRate implements PricingPolicy {

    /**
     * Fiyatı değiştirmeden döndürür.
     * 
     * @param rawPrice Orijinal fiyat
     * @return Aynı fiyat (rawPrice * 1.0)
     */
    public double calculate(double rawPrice) {
        // İşlem yok, ham fiyatı döndür
        return rawPrice;
    }
}
