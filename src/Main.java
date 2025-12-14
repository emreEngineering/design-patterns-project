import behavioral.*;
import core.Rentable;
import cretional.FleetHub;
import cretional.SystemConfig;
import structural.BookingManager;
import structural.WithChildSeat;
import structural.WithGPS;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CAR RENTAL SYSTEM (9 PATTERNS) ===\n");

        // --- CREATIONAL TEST ---
        // 1. Singleton
        SystemConfig.getSettings().loadDatabase();

        // 2. Factory
        FleetHub garage = new FleetHub();
        Rentable myCar = garage.getVehicle("Luxury"); // Mercedes üretildi
        System.out.println("Selected: " + myCar.getDetails() + " (" + myCar.getCost() + " TL)");

        System.out.println("-------------------------------------");

        // --- STRUCTURAL TEST ---
        // 3. Decorator (Özellik Ekleme)
        myCar = new WithGPS(myCar);       // +50
        myCar = new WithChildSeat(myCar); // +100
        System.out.println("Upgraded: " + myCar.getDetails());

        System.out.println("-------------------------------------");

        // --- BEHAVIORAL TEST ---
        // 4. Strategy (Fiyat Hesaplama)
        PricingPolicy policy = new SeasonalDiscount(); // İndirim stratejisi
        double finalPrice = policy.calculate(myCar.getCost());
        System.out.println("Final Price: " + finalPrice);

        // 5. Observer (Bildirim)
        NotificationCenter news = new NotificationCenter();
        news.subscribe(new Customer("Ali"));
        news.subscribe(new Customer("Ayşe"));
        news.blast("New Mercedes S-Class arrived!");

        // 6. behavioral.State (Durum Kontrolü)
        VehicleContext carStatus = new VehicleContext();
        carStatus.requestRent(); // Kirala
        carStatus.requestRent(); // Hata (Zaten kirada)
        carStatus.requestReturn(); // Teslim et

        System.out.println("-------------------------------------");

        // --- GRAND FINALE (FACADE) ---
        // Builder ve Adapter burada, Facade'ın içinde gizli çalışıyor.
        // 7, 8, ve 9. Desenlerin birleşimi

        BookingManager manager = new BookingManager();
        manager.bookRide("Burak Yılmaz", myCar, 5, finalPrice);

        System.out.println("=== SYSTEM SHUTDOWN ===");
    }
}