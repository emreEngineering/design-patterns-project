import behavioral.PricingPolicy;
import behavioral.SeasonalDiscount;
import core.Rentable;
import cretional.FleetHub;
import cretional.SystemConfig;
import structural.BookingManager;
import structural.WithGPS;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CAR RENTAL SYSTEM (ENHANCED FLEET) ===\n");

        // 1. Singleton (Database)
        SystemConfig.getSettings().loadDatabase();

        System.out.println("-------------------------------------");

        // 2. Factory (FleetHub) - ARTIK DAHA ÇEŞİTLİ!
        FleetHub garage = new FleetHub();

        // Farklı türde araçlar üretiyoruz
        Rentable familyCar = garage.getVehicle("Family");   // Minivan
        Rentable luxuryCar = garage.getVehicle("Luxury");   // Spor Araba
        Rentable offRoadCar = garage.getVehicle("SUV");     // SUV

        System.out.println("Option 1: " + familyCar.getDetails() + " -> " + familyCar.getCost() + " TL");
        System.out.println("Option 2: " + luxuryCar.getDetails() + " -> " + luxuryCar.getCost() + " TL");
        System.out.println("Option 3: " + offRoadCar.getDetails() + " -> " + offRoadCar.getCost() + " TL");

        System.out.println("-------------------------------------");

        // 3. Decorator (Birini seçip modifiye edelim)
        // Müşteri "Luxury" aracı seçti ve özellik ekliyor
        Rentable myChoice = luxuryCar;
        myChoice = new WithGPS(myChoice);
        System.out.println("Selected & Modified: " + myChoice.getDetails());

        System.out.println("-------------------------------------");

        // 4. Strategy (Fiyat Hesaplama)
        PricingPolicy policy = new SeasonalDiscount();
        double finalPrice = policy.calculate(myChoice.getCost());
        System.out.println("Final Price (Discounted): " + finalPrice);

        // ... Diğer desenler (Observer, State) aynı kalır ...

        System.out.println("-------------------------------------");

        // 5. Facade (BookingManager) - Final İşlem
        BookingManager manager = new BookingManager();
        manager.bookRide("Cem Yılmaz", myChoice, 3, finalPrice);

        System.out.println("=== SYSTEM SHUTDOWN ===");
    }
}