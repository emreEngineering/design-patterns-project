/**
 * =====================================================================
 *                  PROFESYONEL ARAÇ KİRALAMA SİSTEMİ
 *                    (6 TASARIM DESENİ UYGULAMASI)
 * =====================================================================
 * 
 * Bu proje, yazılım tasarım desenlerinin gerçek dünya senaryolarında
 * nasıl kullanılacağını gösteren bir araç kiralama sistemi örneğidir.
 * 
 * KULLANILAN TASARIM DESENLERİ:
 * ---------------------------------------------------------------------
 * 1. SINGLETON (Tekil)        - SystemConfig: Sistem ayarlarının tek noktadan yönetimi
 * 2. FACTORY METHOD (Fabrika) - FleetHub: Araç üretim fabrikası
 * 3. DECORATOR (Süsleyici)    - CarDecorator: Araçlara dinamik özellik ekleme
 * 4. STRATEGY (Strateji)      - PricingPolicy: Dinamik fiyatlandırma algoritmaları
 * 5. OBSERVER (Gözlemci)      - NotificationSystem: Müşteri bildirim sistemi
 * 6. FACADE (Cephe)           - RentalService: Karmaşık işlemleri basitleştirme
 * 
 * @author Emre
 * @version 1.0
 */

// Gerekli paketlerin import edilmesi
import core.*; // Temel araç sınıflarını içerir (Vehicle, Rentable, vb.)
import creational.FleetHub; // Factory pattern - Araç üretim fabrikası
import creational.SystemConfig; // Singleton pattern - Sistem konfigürasyonu
import structural.*; // Decorator ve Facade pattern sınıflarını içerir

/**
 * Ana uygulama sınıfı - Programın başlangıç noktası
 * 
 * Bu sınıf, tüm tasarım desenlerinin birlikte nasıl çalıştığını
 * gösteren demo senaryoları içerir.
 */
public class Main {

    /**
     * Uygulamanın giriş noktası (entry point)
     * 
     * 3 farklı kiralama senaryosu üzerinden tüm tasarım desenlerinin
     * nasıl entegre çalıştığını gösterir.
     * 
     * @param args Komut satırı argümanları (bu uygulamada kullanılmıyor)
     */
    public static void main(String[] args) {
        // Program başlığını yazdır
        System.out.println("=== ARAÇ KİRALAMA SİSTEMİ (6 TASARIM DESENİ) ===\n");

        // ═══════════════════════════════════════════════════════════════
        // 1. SINGLETON PATTERN - Sistem Başlatma
        // ═══════════════════════════════════════════════════════════════
        //
        // getInstance() metodu ile tek bir SystemConfig nesnesi oluşturulur.
        // Bu nesne tüm uygulama boyunca aynı kalır (veritabanı bağlantısı vb.)
        // Birden fazla getInstance() çağrısı yapılsa da hep aynı nesne döner.
        //
        SystemConfig.getInstance().connectDB();

        // ═══════════════════════════════════════════════════════════════
        // 2. FACTORY PATTERN - Araç Üretim Merkezi Oluşturma
        // ═══════════════════════════════════════════════════════════════
        //
        // FleetHub: Araç üretim fabrikası - hangi tip araç istediğimizi söyleriz,
        // fabrika bize uygun aracı üretir (new Sedan(), new SUV() vb. demeyiz)
        //
        // RentalService: Facade pattern - tüm karmaşık işlemleri tek metotta toplar
        //
        FleetHub factory = new FleetHub(); // Araç fabrikası
        RentalService service = new RentalService(); // Kiralama servisi (Facade)

        // ═══════════════════════════════════════════════════════════════
        // SENARYO 1: AİLE TATİLİ
        // ═══════════════════════════════════════════════════════════════
        // Müşteri: Ali Baba (aile babası)
        // İhtiyaç: Geniş aile aracı + çocuk koltuğu + kış lastiği
        // İndirim: Tatil indirimi (%20)
        // ═══════════════════════════════════════════════════════════════

        // FACTORY PATTERN: "FAMILY" tipi söylüyoruz, fabrika Minivan üretiyor
        // Dikkat: new Minivan() demiyoruz, fabrika karar veriyor
        Rentable familyCar = factory.createVehicle("FAMILY"); // Volkswagen Transporter üretilir

        // DECORATOR PATTERN: Araca ekstra özellikler ekliyoruz
        // Her decorator, önceki aracı sarmalayarak yeni özellik ekler
        familyCar = new WithChildSeat(familyCar); // Bebek koltuğu eklendi (+100 TL)
        familyCar = new WithWinterTires(familyCar); // Kış lastiği eklendi (+80 TL)
        // Sonuç: Minivan + Baby Seat + Winter Tires = 1200 + 100 + 80 = 1380 TL/gün

        // FACADE PATTERN: Tüm karmaşık işlemler tek metodda
        // İçeride: Strategy (indirim), Observer (bildirim), hesaplama yapılıyor
        service.processRental("Ali Baba", familyCar, 7, "HOLIDAY");
        // 7 gün x 1380 TL x 0.8 (tatil indirimi) = 7728 TL

        // ═══════════════════════════════════════════════════════════════
        // SENARYO 2: VIP İŞ ADAMI
        // ═══════════════════════════════════════════════════════════════
        // Müşteri: Elon Musk (VIP kurumsal müşteri)
        // İhtiyaç: Elektrikli lüks araç + özel şoför + GPS
        // İndirim: VIP kurumsal indirim (%30)
        // ═══════════════════════════════════════════════════════════════

        // FACTORY PATTERN: "ELECTRIC" tipi -> Tesla Model S üretiliyor
        Rentable vipCar = factory.createVehicle("ELECTRIC"); // Tesla Model S (2500 TL/gün)

        // DECORATOR PATTERN: VIP müşteri için premium özellikler
        vipCar = new WithChauffeur(vipCar); // Özel şoför eklendi (+500 TL)
        vipCar = new WithGPS(vipCar); // GPS navigasyon eklendi (+50 TL)
        // Sonuç: Tesla + Chauffeur + GPS = 2500 + 500 + 50 = 3050 TL/gün

        // FACADE + STRATEGY + OBSERVER: VIP indirimli kiralama işlemi
        service.processRental("Elon Musk", vipCar, 2, "VIP");
        // 2 gün x 3050 TL x 0.7 (VIP indirimi) = 4270 TL

        // ═══════════════════════════════════════════════════════════════
        // SENARYO 3: GENÇ ÇİFT
        // ═══════════════════════════════════════════════════════════════
        // Müşteri: Genç Çift (standart müşteri)
        // İhtiyaç: Spor araba + açılır tavan (romantik sürüş için)
        // İndirim: Normal fiyat (indirim yok)
        // ═══════════════════════════════════════════════════════════════

        // FACTORY PATTERN: "SPORT" tipi -> Ferrari 488 Spider üretiliyor
        Rentable sportCar = factory.createVehicle("SPORT"); // Ferrari 488 Spider (5000 TL/gün)

        // DECORATOR PATTERN: Romantik sürüş için sunroof
        sportCar = new WithSunroof(sportCar); // Açılır tavan eklendi (+150 TL)
        // Sonuç: Ferrari + Sunroof = 5000 + 150 = 5150 TL/gün

        // FACADE: Normal fiyatla kiralama (indirim yok)
        service.processRental("Genç Çift", sportCar, 3, "NORMAL");
        // 3 gün x 5150 TL x 1.0 (normal fiyat) = 15450 TL

        // Program sonlandırma mesajı
        System.out.println("=== SİSTEM KAPATILIYOR ===");
    }
}