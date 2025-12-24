package creational;

// [1] SINGLETON: SystemConfig
// Veritabanı bağlantısının tek bir noktadan yönetilmesini sağlar.
public class SystemConfig {
    private static SystemConfig instance;

    private SystemConfig() {
        System.out.println("[Singleton] Configuration Initialized.");
    }

    public static SystemConfig getInstance() {
        if (instance == null) instance = new SystemConfig();
        return instance;
    }

    public void connectDB() {
        System.out.println("[Singleton] Database Connected (PostgreSQL).");
    }
}
