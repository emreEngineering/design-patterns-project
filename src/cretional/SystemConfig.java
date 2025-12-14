package cretional;

// [1] SINGLETON -> SystemConfig
// Sistemin veritabanı ayarlarını tek bir noktadan yönetir.
public class SystemConfig {
    private static SystemConfig instance;

    private SystemConfig() {
        // Kurucu metod gizli (private)
    }

    public static SystemConfig getSettings() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public void loadDatabase() {
        System.out.println("[SystemConfig] Veri tabanına bağlandı. (PostgreSQL).");
    }
}
