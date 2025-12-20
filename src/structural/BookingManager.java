package structural;

import core.Rentable;
import cretional.RentalAgreement;

/*
 * ==============================================================================
 *                   FACADE DESIGN PATTERN - BookingManager
 *                        (Cephe Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  FACADE PATTERN NEDİR?                                                     ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Karmaşık alt sistemleri basit bir arayüz arkasına gizleyen desendir.      ║
 * ║  "Tek Tuşla Yönetim" sağlar.                                               ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM (Facade Olmadan):
 * -------------------------
 * Bir araç kiralamak için istemcinin bilmesi gerekenler:
 * 
 *   // 1. Sözleşme oluştur (Builder pattern)
 *   RentalAgreement contract = new RentalAgreement.Draft(user, car, days)
 *       .addFullCoverage()
 *       .sign();
 *   contract.print();
 *   
 *   // 2. Ödeme al (Adapter pattern)
 *   PaymentInterface payment = new PaymentGateway();
 *   payment.process(totalCost);
 *   
 *   // 3. Araç durumunu güncelle (State pattern)
 *   vehicleContext.requestRent();
 *   
 *   // 4. Müşterilere bildirim gönder (Observer pattern)
 *   notificationCenter.blast("Araç kiralandı");
 * 
 * İstemci 4 farklı deseni bilmek zorunda! Bu çok karmaşık.
 * 
 * ÇÖZÜM (Facade ile):
 * -------------------
 *   BookingManager manager = new BookingManager();
 *   manager.bookRide("Cem Yılmaz", car, 3, 1500);  // TEK SATIR!
 * 
 * Tüm karmaşıklık BookingManager arkasına gizlendi.
 * 
 * FACADE PATTERN YAPISINI GÖRSEL:
 * -------------------------------
 *                          ┌──────────────────────┐
 *                          │      İstemci         │
 *                          │      (Main)          │
 *                          └──────────┬───────────┘
 *                                     │
 *                                     │ bookRide()
 *                                     ▼
 *   ╔══════════════════════════════════════════════════════════════════╗
 *   ║                       FACADE                                     ║
 *   ║                   (BookingManager)                               ║
 *   ╚══════════════════════════════════════════════════════════════════╝
 *                     │              │              │
 *            ┌────────┘              │              └────────┐
 *            ▼                       ▼                       ▼
 *   ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
 *   │ RentalAgreement │    │ PaymentGateway  │    │  VehicleContext │
 *   │   (Builder)     │    │   (Adapter)     │    │    (State)      │
 *   └─────────────────┘    └─────────────────┘    └─────────────────┘
 *              ▲                    ▲                      ▲
 *              │        ALT SİSTEMLER (Subsystems)         │
 *              └────────────────────────────────────────────┘
 * 
 * FACADE'İN AVANTAJLARI:
 * ----------------------
 * 1. Basitlik: İstemci tek bir metod çağırır
 * 2. Decoupling: İstemci alt sistemleri bilmez
 * 3. Maintainability: Alt sistem değişse bile facade aynı kalabilir
 * 4. Layer Separation: Katmanlar arası temiz geçiş
 */
public class BookingManager {

    /**
     * TEK METOD İLE TÜM İŞLEMLER (Facade Metodu)
     * ------------------------------------------
     * Bu metod, bir kiralama işlemi için gereken tüm adımları
     * tek bir çağrıda gerçekleştirir.
     * 
     * @param user      Müşteri adı (sözleşme için)
     * @param car       Kiralanan araç (Rentable - herhangi bir araç tipi)
     * @param days      Kiralama süresi (gün)
     * @param totalCost Toplam ücret (Strategy ile hesaplanmış olabilir)
     * 
     *                  İÇ AKIŞ:
     *                  --------
     *                  1. Builder Pattern → Sözleşme oluştur ve imzala
     *                  2. Adapter Pattern → Ödemeyi tahsil et
     * 
     *                  (Opsiyonel olarak eklenebilecekler:)
     *                  3. State Pattern → Araç durumunu güncelle
     *                  4. Observer Pattern → Müşterilere bildirim gönder
     */
    public void bookRide(String user, Rentable car, int days, double totalCost) {

        System.out.println("\n[BookingManager] Rezervasyon süreci başlatılıyor...");

        // ============== ADIM 1: SÖZLEŞME HAZIRLA (Builder Pattern) ==============
        //
        // RentalAgreement.Draft → Builder sınıfı
        // .addFullCoverage() → Opsiyonel özellik ekle
        // .sign() → Build et, ürünü döndür
        //
        RentalAgreement contract = new RentalAgreement.Draft(user, car, days)
                .addFullCoverage() // Tam kapsamlı sigorta
                .sign(); // Sözleşmeyi oluştur

        contract.print(); // Sözleşme detaylarını yazdır

        // ============== ADIM 2: ÖDEMEYİ AL (Adapter Pattern) ==============
        //
        // PaymentGateway: Adapter sınıfı
        // Bizim process() metodumuz → Bankanın transferFunds() metoduna çevrilir
        //
        PaymentInterface payment = new PaymentGateway();
        payment.process(totalCost);

        // ============== (OPSİYONEL) ADIM 3: ARAÇ DURUMUNU GÜNCELLE ==============
        // VehicleContext vehicleContext = new VehicleContext();
        // vehicleContext.requestRent(); // State: Available → OnRoad

        // ============== (OPSİYONEL) ADIM 4: BİLDİRİM GÖNDER ==============
        // NotificationCenter notifications = new NotificationCenter();
        // notifications.blast("Araç kiralandı: " + car.getDetails());

        System.out.println("[BookingManager] Rezervasyon tamamlandı.\n");
    }
}
