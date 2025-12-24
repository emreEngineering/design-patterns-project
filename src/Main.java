import core.*;
import creational.FleetHub;
import creational.SystemConfig;
import structural.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== PROFESSIONAL CAR RENTAL SYSTEM (6 PATTERNS) ===\n");

        // 1. SINGLETON (Başlangıç)
        SystemConfig.getInstance().connectDB();

        // 2. FACTORY (Üretim Merkezi)
        FleetHub factory = new FleetHub();
        RentalService service = new RentalService();

        // --- SENARYO 1: Aile Tatili (core.Minivan + Koltuk + Kış Lastiği + İndirim) ---
        Rentable familyCar = factory.createVehicle("FAMILY"); // core.Minivan üret
        familyCar = new WithChildSeat(familyCar);             // Koltuk ekle
        familyCar = new WithWinterTires(familyCar);           // Lastik ekle

        // Facade çağrısı (Holiday İndirimiyle)
        service.processRental("Ali Baba", familyCar, 7, "HOLIDAY");


        // --- SENARYO 2: VIP İş Adamı (Elektrikli + Şoför + GPS + Kurumsal İndirim) ---
        Rentable vipCar = factory.createVehicle("ELECTRIC");  // Tesla üret
        vipCar = new WithChauffeur(vipCar);                   // Şoför ekle
        vipCar = new WithGPS(vipCar);                         // GPS ekle

        // Facade çağrısı (VIP İndirimiyle)
        service.processRental("Elon Musk", vipCar, 2, "VIP");


        // --- SENARYO 3: Genç Çift (Spor Araba + Sunroof + Normal Fiyat) ---
        Rentable sportCar = factory.createVehicle("SPORT");   // Ferrari üret
        sportCar = new WithSunroof(sportCar);                 // Sunroof ekle

        // Facade çağrısı (Normal Fiyat)
        service.processRental("Genç Çift", sportCar, 3, "NORMAL");

        System.out.println("=== SYSTEM SHUTDOWN ===");
    }
}