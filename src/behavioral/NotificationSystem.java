/**
 * =====================================================================
 *             NOTIFICATION SYSTEM - OBSERVER PATTERN
 *                    (Bildirim Sistemi - Yayıncı)
 * =====================================================================
 * 
 * Bu sınıf, OBSERVER (Gözlemci) tasarım deseninin Publisher (Yayıncı) 
 * tarafını temsil eder. Tüm abonelere bildirim gönderir.
 * 
 * OBSERVER PATTERN'DEKİ ROLÜ:
 * ---------------------------------------------------------------------
 * - Publisher/Subject (Yayıncı/Konu) rolündedir
 * - Abone listesini yönetir (subscribe, unsubscribe)
 * - Tüm abonelere bildirim gönderir (sendAll)
 * 
 * OBSERVER PATTERN'İN AVANTAJLARI:
 * ---------------------------------------------------------------------
 * 1. GEVŞEK BAĞLILIK:
 *    - NotificationSystem, Subscriber arayüzünü bilir
 *    - Customer, EmailSubscriber vb. somut tipleri bilmez
 * 
 * 2. OPEN/CLOSED PRINCIPLE:
 *    - Yeni abone tipi eklemek için mevcut kod değişmez
 *    - Sadece yeni Subscriber implementasyonu eklenir
 * 
 * 3. BİR-ÇOK İLİŞKİ:
 *    - Bir bildirim, birden çok aboneye ulaşır
 *    - Aboneler birbirinden habersizdir
 * 
 * ÇALIŞMA AKIŞI:
 * ---------------------------------------------------------------------
 * 1. NotificationSystem oluştur
 * 2. Aboneleri ekle: notif.subscribe(new Customer("Ali"))
 * 3. Herkese bildirim gönder: notif.sendAll("Aracınız hazır!")
 * 4. Tüm abonelerin notifyUser() metodu çağrılır
 * 
 * @author Emre
 * @version 1.0
 */
package behavioral;

// Java koleksiyon framework'ünden ArrayList ve List
import java.util.ArrayList;
import java.util.List;

/**
 * Bildirim sistemi - Publisher/Subject rolü
 * 
 * Abone listesini tutar ve tüm abonelere bildirim gönderir.
 * Observer pattern'in temel bileşenidir.
 */
public class NotificationSystem {

    /**
     * Abone listesi
     * 
     * private: Dışarıdan doğrudan erişilemez (encapsulation)
     * List<Subscriber>: Polimorfizm - farklı Subscriber tiplerini tutabilir
     * ArrayList: Dinamik boyutlu dizi implementasyonu
     * 
     * Bu liste şunları tutabilir:
     * - Customer nesneleri
     * - Gelecekte: EmailSubscriber, PushSubscriber vb.
     */
    private List<Subscriber> users = new ArrayList<>();

    /**
     * Abone ekleme metodu
     * 
     * Yeni bir aboneyi listeye ekler.
     * 
     * @param user Eklenecek Subscriber (Customer vb.)
     */
    public void subscribe(Subscriber user) {
        users.add(user); // Listeye ekle
    }


    /**
     * Tüm abonelere bildirim gönder
     * 
     * Listedeki her aboneye aynı mesajı gönderir.
     * Bu, Observer pattern'in temel özelliğidir: bir değişiklik,
     * tüm gözlemcilere yayılır.
     * 
     * @param msg Gönderilecek bildirim mesajı
     */
    public void sendAll(String msg) {
        // Enhanced for loop: Listedeki her abone için döngü
        for (Subscriber u : users) {
            // Her abonenin notifyUser() metodunu çağır
            // Polimorfizm: Customer ise SMS, Email ise mail gönderir
            u.notifyUser(msg);
        }
    }
}
