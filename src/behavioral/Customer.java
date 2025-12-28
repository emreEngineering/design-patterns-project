/**
 * =====================================================================
 *                      CUSTOMER SINIFI
 *                    (Müşteri Abone Sınıfı)
 * =====================================================================
 * 
 * Bu sınıf, Subscriber arayüzünü implement eden somut bir abone sınıfıdır.
 * Müşteriyi temsil eder ve bildirim aldığında SMS simülasyonu yapar.
 * 
 * OBSERVER PATTERN'DEKİ ROLÜ:
 * ---------------------------------------------------------------------
 * - Somut Subscriber (Concrete Observer) rolündedir
 * - NotificationSystem'e abone olabilir
 * - Bildirim geldiğinde notifyUser() metodu çağrılır
 * 
 * GELECEKTEKİ GENİŞLETMELER:
 * ---------------------------------------------------------------------
 * - Gerçek SMS API entegrasyonu (Twilio, Nexmo vb.)
 * - E-posta bildirimi için EmailCustomer sınıfı
 * - Push notification için MobileCustomer sınıfı
 * 
 * @author Emre
 * @version 1.0
 */
package behavioral;

/**
 * Müşteri sınıfı - Somut Abone
 * 
 * Subscriber arayüzünü implement eder.
 * Bildirim geldiğinde müşteriye SMS gönderir (simülasyon).
 */
public class Customer implements Subscriber {

    /**
     * Müşteri adı
     * 
     * private: Sadece bu sınıf içinden erişilebilir (encapsulation)
     * Bildirim gönderirken kişiselleştirme için kullanılır.
     */
    private String name;

    /**
     * Customer Constructor
     * 
     * Müşteri adını parametre olarak alır.
     * 
     * @param name Müşteri adı (bildirimde kullanılacak)
     */
    public Customer(String name) {
        this.name = name; // Müşteri adını sakla
    }

    /**
     * Bildirim alma metodu (Subscriber arayüzünden)
     * 
     * NotificationSystem.sendAll() tarafından çağrılır.
     * Gerçek uygulamada burada SMS API'si çağrılır.
     * 
     * @param msg Bildirim mesajı (örn: "Aracınız hazır!")
     */
    @Override
    public void notifyUser(String msg) {
        // Konsola SMS simülasyonu yazdır
        // Gerçek uygulamada: smsClient.send(phoneNumber, msg);
        System.out.println("[Observer] SMS to " + name + ": " + msg);
    }
}
