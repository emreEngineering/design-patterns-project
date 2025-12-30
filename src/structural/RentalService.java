/**
 * =====================================================================
 *                   RENTAL SERVICE - FACADE PATTERN
 *                    (Kiralama Servisi Cephesi)
 * =====================================================================
 * 
 * Bu sınıf, FACADE (Cephe) tasarım desenini uygular.
 * Karmaşık alt sistemleri (Strategy, Observer, hesaplama) tek bir basit
 * metod arkasında gizler.
 * 
 * FACADE PATTERN NEDİR?
 * ---------------------------------------------------------------------
 * - Karmaşık bir sistemin basit bir arayüzünü sağlar
 * - İstemci kodu, alt sistemlerin karmaşıklığından korunur
 * - Tek bir metod çağrısı ile birçok işlem yapılır
 * 
 * NEDEN FACADE KULLANIYORUZ?
 * ---------------------------------------------------------------------
 * 1. BASİTLİK:
 *    - İstemci sadece processRental() çağırır
 *    - Strategy, Observer, hesaplama detaylarını bilmez
 * 
 * 2. GEVŞEK BAĞLILIK:
 *    - Alt sistemler değişse bile facade arayüzü sabit kalır
 *    - İstemci kodu etkilenmez
 * 
 * 3. ORGANIZATIONAL:
 *    - İlgili işlemler mantıksal olarak gruplandırılır
 *    - Kod okunabilirliği artar
 * 
 * FACADE'IN SARDIĞI ALT SİSTEMLER:
 * ---------------------------------------------------------------------
 * 1. Strategy Pattern (PricingPolicy): Fiyat hesaplama stratejileri
 * 2. Observer Pattern (NotificationSystem): Müşteri bildirimleri
 * 3. Temel hesaplamalar: Toplam maliyet hesabı
 * 
 * @author Emre
 * @version 1.0
 */
package structural;

import behavioral.*; // Strategy ve Observer sınıfları
import core.Rentable; // Araç arayüzü

/**
 * Kiralama servisi facade sınıfı
 * 
 * Tüm kiralama sürecini tek bir metod altında toplar.
 * İstemci kodu sadece bu sınıfla etkileşime girer.
 */
public class RentalService {

    /**
     * Ana kiralama işlemi - Facade Method
     * 
     * Bu metod, tüm kiralama sürecini yönetir:
     * 1. Müşteri tipine göre fiyatlandırma stratejisi seçer
     * 2. Toplam maliyeti hesaplar
     * 3. Faturayı yazdırır
     * 4. Müşteriye bildirim gönderir
     * 
     * KULLANIM:
     * service.processRental("Ali", car, 7, "HOLIDAY");
     * // Tek çağrı ile: Strateji seçimi + Hesaplama + Fatura + Bildirim
     * 
     * @param customerName   Müşteri adı (fatura ve bildirim için)
     * @param car            Kiralanacak araç (Rentable - base veya decorated)
     * @param days           Kiralama süresi (gün)
     * @param typeOfCustomer Müşteri tipi ("VIP", "HOLIDAY", "NORMAL")
     */
    public void processRental(String customerName, Rentable car, int days, String typeOfCustomer) {
        // Facade işlem başlangıcı
        System.out.println("\n--- [Facade] Rental Process Starting for: " + customerName + " ---");

        // ═══════════════════════════════════════════════════════════════
        // ADIM 1: STRATEGY PATTERN - Fiyat Stratejisini Seç
        // ═══════════════════════════════════════════════════════════════
        //
        // Müşteri tipine göre uygun PricingPolicy implementasyonunu seç.
        // Bu, STRATEGY PATTERN'in özü: Algoritma çalışma zamanında seçilir.
        //
        PricingPolicy policy; // Strateji arayüzü (polimorfizm)

        if (typeOfCustomer.equalsIgnoreCase("VIP")) {
            // VIP müşteri: %30 kurumsal indirim
            policy = new VipDiscount();
        } else if (typeOfCustomer.equalsIgnoreCase("HOLIDAY")) {
            // Tatil dönemi: %20 sezonluk indirim
            policy = new HolidayDiscount();
        } else {
            // Normal müşteri: İndirim yok
            policy = new NormalPrice();
        }

        // ═══════════════════════════════════════════════════════════════
        // ADIM 2: FİYAT HESAPLAMA
        // ═══════════════════════════════════════════════════════════════
        //
        // car.getCost(): Decorator zincirinden toplam günlük ücret gelir
        // policy.calculate(): Seçilen stratejiye göre indirim uygulanır
        //
        double dailyCost = policy.calculate(car.getCost()); // İndirimli günlük ücret
        double totalCost = dailyCost * days; // Toplam maliyet

        // ═══════════════════════════════════════════════════════════════
        // ADIM 3: FATURA KES
        // ═══════════════════════════════════════════════════════════════
        //
        // car.getDetails(): Decorator zincirinden tüm özellikler gelir
        // Örnek: "[Van] VW Transporter (Family Size) + Baby Seat + Winter Tires"
        //
        System.out.println("core.Vehicle: " + car.getDetails()); // Araç detayları
        System.out.println("Days: " + days); // Kiralama süresi
        System.out.println("Total Cost: " + totalCost + " TL"); // Toplam tutar

        // ═══════════════════════════════════════════════════════════════
        // ADIM 4: OBSERVER PATTERN - Müşteriyi Bilgilendir
        // ═══════════════════════════════════════════════════════════════
        //
        // NotificationSystem: Publisher (Yayıncı) rolünde
        // Customer: Subscriber (Abone) rolünde
        //
        // subscribe(): Müşteriyi abone listesine ekle
        // sendAll(): Tüm abonelere bildirim gönder
        //
        NotificationSystem notif = new NotificationSystem(); // Bildirim sistemi oluştur
        notif.subscribe(new Customer(customerName)); // Müşteriyi abone yap
        notif.sendAll("Aracınız kapıda hazır. İyi yolculuklar!"); // Bildirim gönder

        // Facade işlem bitişi
        System.out.println("--- [Facade] Process Completed ---\n");
    }
}
