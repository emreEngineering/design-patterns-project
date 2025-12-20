package structural;

/*
 * ==============================================================================
 *                    ADAPTER DESIGN PATTERN - PaymentGateway
 *                        (Adaptör Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  ADAPTER PATTERN NEDİR?                                                    ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Uyumsuz iki arayüzü birbirine bağlayan köprü sınıftır.                    ║
 * ║  "Wrapper" olarak da bilinir.                                              ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM:
 * --------
 *   Bizim Sistemimiz:              Bankanın Sistemi:
 *   payment.process(1500);    →    bankApi.transferFunds(1500);
 *         ↑                               ↑
 *    Metod adı farklı!              Parametre adı bile farklı!
 * 
 * Bu iki sistemi doğrudan bağlayamayız. Araya tercüman koymalıyız.
 * 
 * ÇÖZÜM (Adapter):
 * ----------------
 *   PaymentInterface payment = new PaymentGateway(); // Adapter kullan
 *   payment.process(1500);  // Bizim dilimizle konuşuyoruz
 *   
 *   // İçeride:
 *   // PaymentGateway.process(1500) {
 *   //     bankApi.transferFunds(1500);  // Bankanın diline çevriliyor
 *   // }
 * 
 * ADAPTER ÇALIŞMA AKIŞI:
 * ----------------------
 *   ┌────────────┐    process()    ┌─────────────────┐    transferFunds()    ┌───────────────┐
 *   │   Client   │ ──────────────→ │  PaymentGateway │ ────────────────────→ │ LegacyBankApi │
 *   │  (Main)    │                 │   (Adapter)     │                       │  (Adaptee)    │
 *   └────────────┘                 └─────────────────┘                       └───────────────┘
 * 
 * ADAPTER TÜRLERİ:
 * ----------------
 * 1. OBJECT ADAPTER (Nesne Adaptör) - Biz bunu kullandık
 *    - Composition kullanır (içinde Adaptee nesnesi tutar)
 *    - Daha esnek, tercih edilen yöntem
 * 
 * 2. CLASS ADAPTER (Sınıf Adaptör)
 *    - Multiple inheritance kullanır (Java'da mümkün değil)
 *    - C++ gibi dillerde kullanılır
 */
class PaymentGateway implements PaymentInterface {

    /**
     * ADAPTEE REFERANSİ (Uyarlanacak Nesne)
     * ------------------------------------
     * Eski banka API'sini tutan değişken.
     * Composition (bileşim) ilişkisi: "HAS-A" (PaymentGateway bir LegacyBankApi'ye
     * SAHİP)
     * 
     * Bu değişken sayesinde Adapter, Adaptee'nin metodlarını çağırabilir.
     */
    private LegacyBankApi bankApi;

    /**
     * PaymentGateway Constructor
     * --------------------------
     * Adaptee nesnesini oluşturur veya dışarıdan alır.
     * Dependency Injection kullanılabilir (daha iyi test edilebilirlik için).
     */
    public PaymentGateway() {
        this.bankApi = new LegacyBankApi();
    }

    /**
     * ADAPTER METODU - Tercüme İşlemi
     * --------------------------------
     * Bu metod, bizim arayüzümüzden (process) bankanın arayüzüne (transferFunds)
     * tercüme yapar. İstemci sadece process() çağırır, arka plandaki
     * komplikasyonları bilmez.
     * 
     * @param amount Ödeme tutarı (TL)
     * 
     *               GERÇEK DÜNYADA BURADA:
     *               ----------------------
     *               - Para birimi dönüşümü (TL → USD)
     *               - Güvenlik token'ı ekleme
     *               - Request formatı dönüştürme
     *               - Error handling
     *               - Logging
     */
    @Override
    public void process(double amount) {
        System.out.println("[PaymentGateway] Dış bankaya bağlanıyor...");

        // Bizim arayüzümüz → Bankanın arayüzü
        // process(amount) → transferFunds(amt)
        bankApi.transferFunds(amount);
    }
}
