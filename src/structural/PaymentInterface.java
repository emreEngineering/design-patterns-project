package structural;

/*
 * ==============================================================================
 *                    ADAPTER PATTERN - PaymentInterface
 *                   (Adaptör Deseni - Ödeme Arayüzü)
 * ==============================================================================
 * 
 * BU ARAYÜZ NE İŞE YARAR?
 * -----------------------
 * Bu, BİZİM SİSTEMİMİZİN beklediği ödeme arayüzüdür.
 * Sistemimiz "process(amount)" metodunu çağırarak ödeme yapar.
 * 
 * ADAPTER PATTERN SENARYOSU:
 * --------------------------
 *   BİZİM SİSTEM                    BANKANIN SİSTEMİ
 *   ────────────                    ────────────────
 *   process(double amount)   →      transferFunds(double amt)
 *   
 *   İsimler farklı! Doğrudan çağıramayız.
 *   Çözüm: Araya bir ADAPTÖR koymak.
 * 
 * ADAPTER PATTERN YAPISI:
 * -----------------------
 *                     ┌─────────────────────────┐
 *                     │   PaymentInterface      │ ← Bizim beklediğimiz arayüz
 *                     │   (Target Interface)    │
 *                     └───────────┬─────────────┘
 *                                 │
 *                                 │ implements
 *                                 │
 *                     ┌───────────▼─────────────┐
 *                     │    PaymentGateway       │ ← Adaptör
 *                     │    (Adapter)            │
 *                     └───────────┬─────────────┘
 *                                 │
 *                                 │ uses (içeride)
 *                                 │
 *                     ┌───────────▼─────────────┐
 *                     │    LegacyBankApi        │ ← Değiştiremediğimiz eski kod
 *                     │    (Adaptee)            │
 *                     │ transferFunds(amount)   │
 *                     └─────────────────────────┘
 */
interface PaymentInterface {

    /**
     * Ödeme işlemini gerçekleştirir.
     * 
     * @param amount Ödeme tutarı (TL cinsinden)
     * 
     *               Bu metodu çağıran kod, arkada hangi sistemin kullanıldığını
     *               bilmez:
     *               PaymentInterface payment = new PaymentGateway();
     *               payment.process(1500); // İç detaylar gizli
     */
    void process(double amount);
}
