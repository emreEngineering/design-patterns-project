package behavioral;

/*
 * ==============================================================================
 *                   CONCRETE OBSERVER - Customer
 *                      Somut Gözlemci - Müşteri
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * NotificationCenter'a abone olabilen ve bildirim alabilen müşteri sınıfıdır.
 * Subscriber arayüzünü implement eder.
 * 
 * OBSERVER PATTERN'DE ROLÜ:
 * -------------------------
 * Customer = Concrete Observer (Somut Gözlemci)
 * 
 * Diğer somut gözlemci örnekleri (eklenebilir):
 * - EmailSubscriber: E-posta bildirimi gönderir
 * - SMSSubscriber: SMS bildirimi gönderir
 * - PushSubscriber: Mobil push notification gönderir
 * 
 * KULLANIM ÖRNEĞİ:
 * ----------------
 *   // Müşteriler oluştur
 *   Customer ali = new Customer("Ali");
 *   Customer veli = new Customer("Veli");
 *   
 *   // Bildirim merkezine abone ol
 *   NotificationCenter center = new NotificationCenter();
 *   center.subscribe(ali);
 *   center.subscribe(veli);
 *   
 *   // Toplu bildirim gönder
 *   center.blast("Yaz kampanyası başladı!");
 *   
 *   // Çıktı:
 *   // [Notification] Merhaba Ali, Yaz kampanyası başladı!
 *   // [Notification] Merhaba Veli, Yaz kampanyası başladı!
 */
public class Customer implements Subscriber {

    /**
     * Müşterinin adı.
     * Bildirim mesajlarında kişiselleştirme için kullanılır.
     */
    private String name;

    /**
     * Customer Constructor
     * 
     * @param name Müşteri adı (örn: "Ali", "Veli")
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * BİLDİRİM ALMA METODU (Observer Callback)
     * ----------------------------------------
     * NotificationCenter.blast() çağrıldığında bu metod otomatik tetiklenir.
     * 
     * @param news Gelen bildirim mesajı
     * 
     *             Bu metodun çağrılma sırası:
     *             1. NotificationCenter.blast("Mesaj") çağrılır
     *             2. NotificationCenter, tüm subscribers listesini döner
     *             3. Her subscriber için update(news) çağrılır
     *             4. Customer.update() çalışır ve mesajı gösterir
     */
    @Override
    public void update(String news) {
        // Kişiselleştirilmiş mesaj göster
        System.out.println("[Notification] Merhaba " + name + ", " + news);
    }
}
