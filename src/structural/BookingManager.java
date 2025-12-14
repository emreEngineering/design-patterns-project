package structural;

import core.Rentable;
import cretional.RentalAgreement;

// [6] FACADE -> BookingManager
// Karmaşık alt sistemleri (Builder, Adapter vb.) tek metotta toplar.
public class BookingManager {
    public void bookRide(String user, Rentable car, int days, double totalCost) {
        System.out.println("\n[BookingManager] Rezervasyon süreci başlatılıyor...");

        // 1. Sözleşmeyi Hazırla (Builder kullanılıyor)
        RentalAgreement contract = new RentalAgreement.Draft(user, car, days)
                .addFullCoverage()
                .sign();
        contract.print();

        // 2. Ödemeyi Al (Adapter kullanılıyor)
        PaymentInterface payment = new PaymentGateway();
        payment.process(totalCost);

        System.out.println("[BookingManager] Rezervasyon tamamlandı.\n");
    }
}
