package behavioral;

/*
 * ==============================================================================
 *                   OBSERVER DESIGN PATTERN - Subscriber
 *                        (Gözlemci Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  OBSERVER PATTERN NEDİR?                                                   ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Bir nesnenin durumu değiştiğinde bağlı tüm nesneleri OTOMATİK olarak      ║
 * ║  bilgilendiren yayıncı-abone sistemidir.                                   ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * TERMINOLOJI:
 * ------------
 * - SUBJECT (Konu/Yayıncı): NotificationCenter - Olayları yayınlar
 * - OBSERVER (Gözlemci/Abone): Customer - Olayları dinler
 * - SUBSCRIBE: Abone olma işlemi
 * - NOTIFY: Bildirim gönderme işlemi
 * 
 * PROBLEM (Observer Olmadan):
 * ---------------------------
 * Polling (Yoklama) yaklaşımı:
 * 
 *   while (true) {
 *       if (garage.hasNewCar()) {
 *           System.out.println("Yeni araç geldi!");
 *           break;
 *       }
 *       Thread.sleep(5000); // 5 saniyede bir kontrol
 *   }
 * 
 * SORUNLAR:
 * - Gereksiz sistem kaynağı kullanımı
 * - Gecikmeli bildirim (polling aralığı kadar)
 * - Her müşteri kendi polling'ini yapmalı
 * 
 * ÇÖZÜM (Observer ile - Push Notification):
 * -----------------------------------------
 *   NotificationCenter center = new NotificationCenter();
 *   center.subscribe(customer1);  // Abone ol
 *   center.subscribe(customer2);
 *   
 *   // Araç geldiğinde:
 *   center.blast("Yeni araç geldi!");  // Otomatik bildirim
 * 
 * OBSERVER PATTERN YAPISI:
 * ------------------------
 *                     ┌─────────────────────┐
 *                     │  NotificationCenter │ ← Subject (Yayıncı)
 *                     │  - subscribers[]    │
 *                     │  + subscribe()      │
 *                     │  + blast()          │
 *                     └─────────┬───────────┘
 *                               │ notifies
 *                               ▼
 *                     ┌─────────────────────┐
 *                     │    Subscriber       │ ← Observer Interface
 *                     │  + update(news)     │
 *                     └─────────┬───────────┘
 *                               │
 *                               ▼
 *                     ┌─────────────────────┐
 *                     │     Customer        │ ← Concrete Observer
 *                     │  - name             │
 *                     │  + update(news)     │
 *                     └─────────────────────┘
 */
interface Subscriber {

    /**
     * Bildirim alındığında çağrılan metod.
     * 
     * @param news Bildirim mesajı (örn: "Yeni araç geldi!", "Kampanya başladı!")
     * 
     *             Her abone bu metodu kendi şekliyle implement eder:
     *             - Customer: Ekrana yazdırır
     *             - EmailSubscriber: E-posta gönderir
     *             - SMSSubscriber: SMS gönderir
     */
    void update(String news);
}
