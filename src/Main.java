import behavioral.PricingPolicy;
import behavioral.SeasonalDiscount;
import core.Rentable;
import cretional.FleetHub;
import cretional.SystemConfig;
import structural.BookingManager;
import structural.WithGPS;

/*
 * ==============================================================================
 *                       CAR RENTAL SYSTEM - MAIN CLASS
 *                    Araç Kiralama Sistemi - Ana Uygulama
 * ==============================================================================
 * 
 *                     ╔══════════════════════════════════════╗
 *                     ║   9 TASARIM DESENİ TEK PROJEDE!      ║
 *                     ╚══════════════════════════════════════╝
 * 
 * KULLANILAN DESENLERİN ÖZETİ:
 * ----------------------------
 * ┌─────────────────────────────────────────────────────────────────────────────┐
 * │ CREATIONAL (Yaratımsal)                                                     │
 * │ ─────────────────────────────────────────────────────────────────────────── │
 * │ 1. SINGLETON    → SystemConfig  : Tek veritabanı bağlantısı                 │
 * │ 2. FACTORY      → FleetHub      : Araç üretim fabrikası                     │
 * │ 3. BUILDER      → RentalAgreement: Sözleşme oluşturucu                      │
 * ├─────────────────────────────────────────────────────────────────────────────┤
 * │ STRUCTURAL (Yapısal)                                                        │
 * │ ─────────────────────────────────────────────────────────────────────────── │
 * │ 4. DECORATOR    → FeatureAddon  : GPS, Koltuk gibi ek özellikler            │
 * │ 5. ADAPTER      → PaymentGateway: Banka API entegrasyonu                    │
 * │ 6. FACADE       → BookingManager: Tek tuşla kiralama                        │
 * ├─────────────────────────────────────────────────────────────────────────────┤
 * │ BEHAVIORAL (Davranışsal)                                                    │
 * │ ─────────────────────────────────────────────────────────────────────────── │
 * │ 7. STRATEGY     → PricingPolicy : Dinamik fiyatlandırma                     │
 * │ 8. OBSERVER     → NotificationCenter: Müşteri bildirimleri                  │
 * │ 9. STATE        → VehicleContext: Araç durum yönetimi                       │
 * └─────────────────────────────────────────────────────────────────────────────┘
 * 
 * SİSTEM AKIŞ DİYAGRAMI:
 * ----------------------
 *   ┌────────────────────────────────────────────────────────────────────────┐
 *   │                           BAŞLANGIÇ                                    │
 *   └──────────────────────────────┬─────────────────────────────────────────┘
 *                                  │
 *                                  ▼
 *   ┌────────────────────────────────────────────────────────────────────────┐
 *   │  1. [SINGLETON] SystemConfig.getSettings().loadDatabase()              │
 *   │     → Veritabanı bağlantısı TEK SEFERLIK oluşturulur                   │
 *   └──────────────────────────────┬─────────────────────────────────────────┘
 *                                  │
 *                                  ▼
 *   ┌────────────────────────────────────────────────────────────────────────┐
 *   │  2. [FACTORY] FleetHub.getVehicle("Luxury")                            │
 *   │     → Fabrika üzerinden araç oluşturulur (hangi sınıf gizli)           │
 *   └──────────────────────────────┬─────────────────────────────────────────┘
 *                                  │
 *                                  ▼
 *   ┌────────────────────────────────────────────────────────────────────────┐
 *   │  3. [DECORATOR] new WithGPS(luxuryCar)                                 │
 *   │     → Araca dinamik olarak GPS özelliği eklenir                        │
 *   └──────────────────────────────┬─────────────────────────────────────────┘
 *                                  │
 *                                  ▼
 *   ┌────────────────────────────────────────────────────────────────────────┐
 *   │  4. [STRATEGY] SeasonalDiscount.calculate(price)                       │
 *   │     → Mevsimlik indirim stratejisi uygulanır (-%20)                    │
 *   └──────────────────────────────┬─────────────────────────────────────────┘
 *                                  │
 *                                  ▼
 *   ┌────────────────────────────────────────────────────────────────────────┐
 *   │  5. [FACADE] BookingManager.bookRide(...)                              │
 *   │     ├── [BUILDER] RentalAgreement.Draft → Sözleşme hazırlanır          │
 *   │     └── [ADAPTER] PaymentGateway → Ödeme alınır                        │
 *   └──────────────────────────────┬─────────────────────────────────────────┘
 *                                  │
 *                                  ▼
 *   ┌────────────────────────────────────────────────────────────────────────┐
 *   │                             BİTİŞ                                      │
 *   └────────────────────────────────────────────────────────────────────────┘
 */
public class Main {

    /**
     * Ana uygulama giriş noktası.
     * Tüm design pattern'ler burada entegre çalışır.
     * 
     * @param args Komut satırı argümanları (kullanılmıyor)
     */
    public static void main(String[] args) {

        System.out.println("=== CAR RENTAL SYSTEM (ENHANCED FLEET) ===\n");

        // ══════════════════════════════════════════════════════════════════════
        // ADIM 1: SINGLETON PATTERN - Sistem Konfigürasyonu
        // ══════════════════════════════════════════════════════════════════════
        // SystemConfig Singleton olduğu için:
        // - İlk çağrıda nesne oluşturulur
        // - Sonraki çağrılarda AYNI nesne döner
        // - Tüm uygulama tek bir konfigürasyon paylaşır
        //
        // Avantaj: Bellek tasarrufu, tutarlı konfigürasyon
        // ─────────────────────────────────────────────────────────────────────
        SystemConfig.getSettings().loadDatabase();

        System.out.println("-------------------------------------");

        // ══════════════════════════════════════════════════════════════════════
        // ADIM 2: FACTORY METHOD PATTERN - Araç Üretimi
        // ══════════════════════════════════════════════════════════════════════
        // FleetHub fabrikası kategori adına göre uygun aracı üretir.
        // Kullanıcı hangi sınıfın oluşturulduğunu bilmez (Loose Coupling).
        //
        // Avantaj: Yeni araç tipi eklemek için Main.java değişmez
        // ─────────────────────────────────────────────────────────────────────
        FleetHub garage = new FleetHub();

        // Farklı kategorilerde araçlar üret
        Rentable familyCar = garage.getVehicle("Family"); // → Minivan
        Rentable luxuryCar = garage.getVehicle("Luxury"); // → SportsCar
        Rentable offRoadCar = garage.getVehicle("SUV"); // → SUV

        // Üretilen araçları göster
        System.out.println("Option 1: " + familyCar.getDetails() + " -> " + familyCar.getCost() + " TL");
        System.out.println("Option 2: " + luxuryCar.getDetails() + " -> " + luxuryCar.getCost() + " TL");
        System.out.println("Option 3: " + offRoadCar.getDetails() + " -> " + offRoadCar.getCost() + " TL");

        System.out.println("-------------------------------------");

        // ══════════════════════════════════════════════════════════════════════
        // ADIM 3: DECORATOR PATTERN - Ek Özellik Ekleme
        // ══════════════════════════════════════════════════════════════════════
        // Müşteri "Luxury" (SportsCar) seçti ve GPS özelliği istiyor.
        // Decorator pattern ile araca çalışma anında özellik ekleniyor.
        //
        // myChoice nesnesinin yapısı:
        // WithGPS
        // └── SportsCar (Porsche 911 Carrera, 5000 TL)
        //
        // Fiyat: 5000 + 50 (GPS) = 5050 TL
        // ─────────────────────────────────────────────────────────────────────
        Rentable myChoice = luxuryCar;
        myChoice = new WithGPS(myChoice); // GPS özelliği ekle

        System.out.println("Selected & Modified: " + myChoice.getDetails());

        System.out.println("-------------------------------------");

        // ══════════════════════════════════════════════════════════════════════
        // ADIM 4: STRATEGY PATTERN - Fiyat Hesaplama
        // ══════════════════════════════════════════════════════════════════════
        // Mevsimlik indirim stratejisi uygulanıyor.
        // SeasonalDiscount: %20 indirim yapar (x0.8)
        //
        // Başka stratejiler kolayca değiştirilebilir:
        // PricingPolicy policy = new StandardRate(); // Normal fiyat
        // PricingPolicy policy = new BlackFriday(); // %40 indirim
        // ─────────────────────────────────────────────────────────────────────
        PricingPolicy policy = new SeasonalDiscount();
        double finalPrice = policy.calculate(myChoice.getCost()); // 5050 * 0.8 = 4040

        System.out.println("Final Price (Discounted): " + finalPrice);

        // ══════════════════════════════════════════════════════════════════════
        // (GÖSTERILMEMIŞ) OBSERVER ve STATE PATTERN
        // ══════════════════════════════════════════════════════════════════════
        // Observer: NotificationCenter ile müşterilere bildirim
        // NotificationCenter center = new NotificationCenter();
        // center.subscribe(new Customer("Ali"));
        // center.blast("Araç kiralandı!");
        //
        // State: VehicleContext ile araç durumu yönetimi
        // VehicleContext ctx = new VehicleContext();
        // ctx.requestRent(); // Available → OnRoad
        // ctx.requestReturn(); // OnRoad → Available
        // ─────────────────────────────────────────────────────────────────────

        System.out.println("-------------------------------------");

        // ══════════════════════════════════════════════════════════════════════
        // ADIM 5: FACADE PATTERN - Tek Tuşla Kiralama
        // ══════════════════════════════════════════════════════════════════════
        // BookingManager tüm karmaşık işlemleri arkasına gizler:
        //
        // bookRide() içinde sırasıyla:
        // 1. [BUILDER] RentalAgreement sözleşmesi oluşturulur
        // 2. [ADAPTER] PaymentGateway üzerinden ödeme alınır
        // (opsiyonel: State güncellenir, Observer ile bildirim gider)
        //
        // Kullanıcı sadece TEK METOD çağırır, gerisi otomatik!
        // ─────────────────────────────────────────────────────────────────────
        BookingManager manager = new BookingManager();
        manager.bookRide("Cem Yılmaz", myChoice, 3, finalPrice);

        System.out.println("=== SYSTEM SHUTDOWN ===");
    }
}