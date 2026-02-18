/**
 * =====================================================================
 *                   SYSTEM CONFIG - SINGLETON PATTERN
 *                    (Tekil Sistem Konfigürasyonu)
 * =====================================================================
 * 
 * Bu sınıf, SINGLETON (Tekil) tasarım desenini uygular.
 * Tüm uygulama boyunca sadece BİR TANE SystemConfig nesnesi olmasını garanti eder.
 * 
 * SINGLETON PATTERN NEDİR?
 * ---------------------------------------------------------------------
 * - Bir sınıftan sadece tek bir nesne oluşturulmasını sağlar
 * - Global erişim noktası sunar (getInstance() metodu)
 * - Kaynak tasarrufu sağlar (veritabanı bağlantısı, konfigürasyon vb.)
 * 
 * NEDEN SINGLETON KULLANIYORUZ?
 * ---------------------------------------------------------------------
 * 1. Veritabanı bağlantısı tüm uygulamada tek olmalı
 * 2. Sistem ayarları her yerden erişilebilir olmalı
 * 3. Birden fazla bağlantı açılması kaynak israfına yol açar
 * 
 * SINGLETON'IN TEMEL ÖZELLİKLERİ:
 * ---------------------------------------------------------------------
 * 1. Private constructor: Dışarıdan new ile nesne oluşturulamaz
 * 2. Static instance: Tek nesne static olarak tutulur
 * 3. Static getInstance(): Nesneye erişim için tek yol
 * 
 * @author Emre
 * @version 1.0
 */
package creational;

/**
 * Singleton tasarım deseni ile sistem konfigürasyonu
 * 
 * Kullanım:
 * SystemConfig.getInstance().connectDB(); // Doğru kullanım
 * new SystemConfig(); // HATA! Constructor private
 */
public class SystemConfig {

    /**
     * İlk başta null, getInstance() çağrılınca oluşturulur (Lazy Initialization)
     */
    private static SystemConfig instance;

    /**
     * Private Constructor (Özel Yapıcı)
     * Bu, birden fazla nesne oluşturulmasını engeller.
     * 
     * Sadece getInstance() metodu içinden çağrılabilir.
     */
    private SystemConfig() {
        // Konfigürasyon başlatıldığında bilgi mesajı
        System.out.println("[Singleton] Yapılandırması Başlatıldı.");
    }

    /**
     * Singleton nesnesine erişim metodu
     * 
     * ÇALIŞMA MANTIGI:
     * 1. İlk çağrı: instance == null → Yeni nesne oluştur
     * 2. Sonraki çağrılar: instance != null → Mevcut nesneyi döndür
     *
     * @return Tek SystemConfig nesnesi
     */
    public static SystemConfig getInstance() {
        // Lazy Initialization: Nesne yoksa oluştur
        if (instance == null) {
            instance = new SystemConfig(); // İlk ve tek oluşturma
        }
        return instance; // Her zaman aynı nesneyi döndür
    }

    /**
     * Veritabanı bağlantısını başlatır
     */
    public void connectDB() {
        System.out.println("[Singleton] Veritabanına Bağlandı (PostgreSQL)..");
    }
}
