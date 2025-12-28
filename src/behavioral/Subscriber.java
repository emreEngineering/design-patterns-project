/**
 * =====================================================================
 *                 SUBSCRIBER - OBSERVER PATTERN
 *                    (Abone/Gözlemci Arayüzü)
 * =====================================================================
 * 
 * Bu arayüz, OBSERVER (Gözlemci) tasarım deseninin abone tarafını tanımlar.
 * Bildirim almak isteyen tüm sınıflar bu arayüzü implement eder.
 * 
 * OBSERVER PATTERN NEDİR?
 * ---------------------------------------------------------------------
 * - Nesneler arasında bir-çok (one-to-many) bağımlılık tanımlar
 * - Bir nesne (Publisher/Subject) durumu değiştiğinde tüm bağımlıları bilgilendirilir
 * - Gevşek bağlılık sağlar: Publisher, Subscriber'ların somut tiplerini bilmez
 * 
 * ROLLER:
 * ---------------------------------------------------------------------
 * 1. PUBLISHER (Yayıncı): NotificationSystem
 *    - Abone listesini tutar
 *    - Değişiklik olduğunda tüm aboneleri bilgilendirir
 * 
 * 2. SUBSCRIBER (Abone): Customer, Email, SMS vb.
 *    - Bildirimleri almak için abone olur
 *    - Bildirim geldiğinde tepki verir
 * 
 * GERÇEK DÜNYA KARŞILIĞI:
 * ---------------------------------------------------------------------
 * - YouTube: Kanal (Publisher) + Aboneler (Subscriber)
 * - Gazete: Yayınevi (Publisher) + Okuyucular (Subscriber)
 * - Kiralama: Sistem (Publisher) + Müşteriler (Subscriber)
 * 
 * @author Emre
 * @version 1.0
 */
package behavioral;

/**
 * Abone (Gözlemci) arayüzü
 * 
 * Bildirim almak isteyen tüm sınıflar bu arayüzü implement etmelidir.
 * Bu sayede NotificationSystem, farklı abone tiplerini destekleyebilir.
 */
interface Subscriber {

    /**
     * Bildirim alma metodu
     * 
     * Publisher (NotificationSystem) tarafından çağrılır.
     * Her abone bu metodu implement ederek bildirimi işler.
     * 
     * Örnek implementasyonlar:
     * - Customer: SMS gönderir
     * - EmailSubscriber: E-posta gönderir
     * - PushSubscriber: Mobil bildirim gönderir
     * 
     * @param msg Gönderilecek bildirim mesajı
     */
    void notifyUser(String msg);
}
