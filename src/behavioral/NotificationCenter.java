package behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 * ==============================================================================
 *                    SUBJECT (PUBLISHER) - NotificationCenter
 *                          Yayıncı - Bildirim Merkezi
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * Observer pattern'daki "Subject" (Konu/Yayıncı) rolünü üstlenir.
 * Aboneleri (Subscriber) yönetir ve toplu bildirim gönderir.
 * 
 * OBSERVER PATTERN AKIŞI:
 * -----------------------
 *   1. Müşteriler abone olur    → subscribe(customer)
 *   2. Bir olay gerçekleşir     → Örn: Araç stoğa geldi
 *   3. Yayıncı bildirim gönderir → blast("Yeni araç geldi!")
 *   4. Tüm aboneler bilgilendirilir → Her biri update() ile
 * 
 *                    ┌─────────────────────────┐
 *                    │   NotificationCenter    │
 *                    │ ─────────────────────── │
 *                    │  subscribers: [c1, c2]  │
 *                    │ ─────────────────────── │
 *                    │  + subscribe(s)         │
 *                    │  + blast(msg)           │
 *                    └────────────┬────────────┘
 *                                 │
 *       ┌─────────────────────────┼─────────────────────────┐
 *       │ blast("msg")            │                         │
 *       ▼                         ▼                         ▼
 *   ┌───────────┐           ┌───────────┐            ┌───────────┐
 *   │ Customer1 │           │ Customer2 │            │ Customer3 │
 *   │ update()  │           │ update()  │            │ update()  │
 *   └───────────┘           └───────────┘            └───────────┘
 * 
 * GERÇEK HAYAT ÖRNEKLERİ:
 * -----------------------
 * - YouTube: Kanal yeni video yükler → Aboneler bildirim alır
 * - Twitter: Birisi tweet atar → Takipçiler görür
 * - E-ticaret: Ürün stoğa girer → Bekleyenler e-posta alır
 */
public class NotificationCenter {

    /**
     * ABONE LİSTESİ
     * -------------
     * Bildirimleri alacak tüm aboneleri tutar.
     * List kullandık çünkü:
     * - Dinamik boyut (istediğimiz kadar abone)
     * - Kolay iterasyon (for-each ile döngü)
     */
    private List<Subscriber> users = new ArrayList<>();

    /**
     * ABONE EKLEME (Subscribe)
     * ------------------------
     * Yeni bir abone ekler. Artık bu abone bildirim alacaktır.
     * 
     * @param user Abone olacak nesne (Customer veya başka Subscriber)
     * 
     *             ÖRNEK:
     *             NotificationCenter center = new NotificationCenter();
     *             center.subscribe(new Customer("Ali"));
     *             center.subscribe(new Customer("Veli"));
     */
    public void subscribe(Subscriber user) {
        users.add(user);
    }

    /*
     * EKLENEBİLECEK METODLAR:
     * -----------------------
     * public void unsubscribe(Subscriber user) {
     * users.remove(user); // Abonelikten çık
     * }
     * 
     * public int getSubscriberCount() {
     * return users.size(); // Toplam abone sayısı
     * }
     */

    /**
     * TOPLU BİLDİRİM (Broadcast/Blast)
     * --------------------------------
     * Tüm abonelere aynı mesajı gönderir.
     * 
     * Çalışma mantığı:
     * 1. Subscriber listesinde döngü
     * 2. Her subscriber için update() çağır
     * 3. Mesaj tüm abonelere ulaşır
     * 
     * @param message Gönderilecek bildirim mesajı
     * 
     *                ÖRNEK:
     *                center.blast("Yaz indirimi başladı!");
     *                // Çıktı:
     *                // [behavioral.NotificationCenter] Toplu mesaj gönderiyorum...
     *                // [Notification] Merhaba Ali, Yaz indirimi başladı!
     *                // [Notification] Merhaba Veli, Yaz indirimi başladı!
     */
    public void blast(String message) {
        System.out.println("[behavioral.NotificationCenter] Toplu mesaj gönderiyorum...");

        // Tüm abonelere mesaj gönder
        for (Subscriber user : users) {
            user.update(message); // Her abonenin update() metodu çağrılır
        }
    }
}
