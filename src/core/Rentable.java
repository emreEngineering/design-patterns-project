/**
 * =====================================================================
 *                         RENTABLE ARAYÜZÜ
 *                    (Kiralanabilir Nesne Sözleşmesi)
 * =====================================================================
 * 
 * Bu arayüz, kiralanabilir tüm nesneler için ortak bir sözleşme tanımlar.
 * Hem temel araçlar (Sedan, SUV, vb.) hem de dekoratörler (GPS, Şoför, vb.)
 * bu arayüzü uygular.
 * 
 * TASARIM DESENİ BAĞLAMI:
 * ---------------------------------------------------------------------
 * DECORATOR PATTERN için kritik öneme sahiptir:
 * - Hem Component (araç) hem Decorator (eklenti) aynı arayüzü kullanır
 * - Bu sayede decorator'lar araçları sarmalayabilir
 * - İstemci kodu, aracın dekorasyonlu olup olmadığını bilmek zorunda kalmaz
 * 
 * Polimorfizm (Çok Biçimlilik):
 * - Rentable tipinde bir değişken hem Sedan hem de WithGPS tutabilir
 * - Bu, araçların dinamik olarak özellik kazanmasını sağlar
 * 
 * @author Emre
 * @version 1.0
 */
package core;

/**
 * Kiralanabilir nesneler için temel arayüz
 * 
 * Bu arayüz, Liskov Substitution Principle'a uygun olarak tasarlanmıştır:
 * Alt sınıflar (Sedan, SUV, WithGPS vb.) üst sınıf yerine kullanılabilir.
 */
public interface Rentable {

    /**
     * Aracın detay bilgilerini döndürür
     * 
     * Decorator pattern'de bu metot zincirleme çağrılır:
     * Örnek: WithGPS.getDetails() -> WithChildSeat.getDetails() ->
     * Minivan.getDetails()
     * Sonuç: "[Van] Volkswagen Transporter (Family Size) + Baby Seat + GPS"
     * 
     * @return Araç açıklaması ve eklenen özelliklerin birleşimi
     */
    String getDetails();

    /**
     * Aracın günlük kiralama ücretini döndürür
     * 
     * Decorator pattern'de her eklenti kendi ücretini ekler:
     * Örnek: WithGPS.getCost() = tempCar.getCost() + 50
     * → Temel araç ücreti + GPS ücreti
     * 
     * @return Günlük kiralama ücreti (TL cinsinden)
     */
    double getCost();
}
