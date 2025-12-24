package structural;

import core.Rentable;

// [6] FACADE: RentalService
// Tüm karmaşık alt sistemleri (Strategy, Observer, Hesaplama) tek metodda toplar.
public class RentalService {
    public void processRental(String customerName, Rentable car, int days, String typeOfCustomer) {
        System.out.println("\n--- [Facade] Rental Process Starting for: " + customerName + " ---");

        // 1. Fiyat Stratejisini Seç
        PricingPolicy policy;
        if (typeOfCustomer.equalsIgnoreCase("VIP")) {
            policy = new VipDiscount();
        } else if (typeOfCustomer.equalsIgnoreCase("HOLIDAY")) {
            policy = new HolidayDiscount();
        } else {
            policy = new NormalPrice();
        }

        // 2. Fiyatı Hesapla
        double dailyCost = policy.calculate(car.getCost());
        double totalCost = dailyCost * days;

        // 3. Faturayı Kes
        System.out.println("core.Vehicle: " + car.getDetails());
        System.out.println("Days: " + days);
        System.out.println("Total Cost: " + totalCost + " TL");

        // 4. Müşteriyi Bilgilendir (Observer)
        NotificationSystem notif = new NotificationSystem();
        notif.subscribe(new Customer(customerName));
        notif.sendAll("Your car is ready at the gate. Enjoy your ride!");

        System.out.println("--- [Facade] Process Completed ---\n");
    }
}
