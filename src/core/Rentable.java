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
 */
public interface Rentable {

    /**
     * Aracın detay bilgilerini döndürür
     */
    String getDetails();

    /**
     * Aracın günlük kiralama ücretini döndürür
     */
    double getCost();
}
