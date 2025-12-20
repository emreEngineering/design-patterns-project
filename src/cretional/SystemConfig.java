package cretional;

/*
 * ==============================================================================
 *                    SINGLETON DESIGN PATTERN - SystemConfig
 *                         (Tekil Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  SINGLETON PATTERN NEDİR?                                                  ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Bir sınıftan SADECE BİR TANE nesne oluşturulmasını garanti eden           ║
 * ║  tasarım desenidir. Tüm uygulama bu tek nesneyi paylaşır.                  ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM (Singleton Olmadan):
 * ----------------------------
 * Sistemde 1000 kiralama işlemi yapıldığında her seferinde yeni bir
 * veritabanı bağlantısı açılırsa:
 * 
 *   DatabaseConnection db1 = new DatabaseConnection(); // 1. bağlantı
 *   DatabaseConnection db2 = new DatabaseConnection(); // 2. bağlantı
 *   ... (1000 bağlantı)
 * 
 * Sonuç: Sunucu kaynakları tükenir, performans düşer, sistem çöker!
 * 
 * ÇÖZÜM (Singleton ile):
 * ----------------------
 *   SystemConfig config1 = SystemConfig.getSettings(); // İlk çağrı: Nesne oluşur
 *   SystemConfig config2 = SystemConfig.getSettings(); // İkinci çağrı: AYNI nesne döner
 *   
 *   System.out.println(config1 == config2); // true (Aynı nesne!)
 * 
 * SINGLETON'IN 3 TEMEL KURALI:
 * ----------------------------
 * 1. Private Constructor: Dışarıdan "new" ile nesne oluşturulamaz
 * 2. Static Instance: Sınıf seviyesinde tek bir nesne tutulur
 * 3. Public Static Method: Nesneye erişim için global bir metod sağlanır
 * 
 * GERÇEK HAYAT ÖRNEKLERİ:
 * -----------------------
 * - Veritabanı bağlantı havuzu (Connection Pool)
 * - Uygulama ayarları (Configuration)
 * - Logger (Kayıt tutucu)
 * - Cache (Önbellek) yöneticisi
 */
public class SystemConfig {

    // ==================== SINGLETON PATTERN ÖĞELERİ ====================

    /**
     * STATIC INSTANCE (Tekil Örnek)
     * -----------------------------
     * Bu değişken sınıf seviyesinde tek bir nesne tutar.
     * "static" olduğu için tüm uygulama boyunca aynı değişken paylaşılır.
     * Başlangıçta null'dır, ilk getSettings() çağrısında oluşturulur.
     */
    private static SystemConfig instance;

    /**
     * PRIVATE CONSTRUCTOR (Gizli Yapıcı Metod)
     * ----------------------------------------
     * Constructor "private" olduğu için dışarıdan şu kod yazılamaz:
     * new SystemConfig(); // HATA! Constructor private
     * 
     * Bu sayede nesne oluşturma kontrolü tamamen sınıfın elindedir.
     */
    private SystemConfig() {
        // Boş bırakıldı - gerçek projede burada initialization yapılır
        // Örnek: Konfigürasyon dosyası okunabilir, varsayılan değerler atanabilir
    }

    /**
     * GLOBAL ACCESS POINT (Küresel Erişim Noktası)
     * ---------------------------------------------
     * Bu static metod, singleton nesnesine erişmenin TEK yoludur.
     * 
     * LAZY INITIALIZATION (Tembel Başlatma):
     * İlk çağrıda nesne oluşturulur, sonraki çağrılarda aynı nesne döner.
     * 
     * @return SystemConfig'in tek örneği (instance)
     * 
     *         DİKKAT: Bu basit implementasyon THREAD-SAFE değildir!
     *         Multi-threaded ortamda "synchronized" veya "double-checked locking"
     *         kullanın.
     */
    public static SystemConfig getSettings() {
        // Eğer henüz nesne oluşturulmamışsa
        if (instance == null) {
            // İlk ve son kez nesneyi oluştur
            instance = new SystemConfig();
        }
        // Her zaman aynı nesneyi döndür
        return instance;
    }

    // ==================== İŞ METODLARI ====================

    /**
     * Veritabanı bağlantısını açar.
     * Gerçek projede burada JDBC bağlantısı kurulur.
     * 
     * Kullanım:
     * SystemConfig.getSettings().loadDatabase();
     */
    public void loadDatabase() {
        System.out.println("[SystemConfig] Veri tabanına bağlandı. (PostgreSQL).");
    }
}
