/**
 * =====================================================================
 *                      VEHICLE SOYUT SINIFI
 *                    (Tüm Araçların Ana Şablonu)
 * =====================================================================
 * 
 * Bu soyut sınıf, tüm araç tiplerinin (Sedan, SUV, ElectricCar vb.)
 * ortak özelliklerini ve davranışlarını tanımlar.
 * 
 * NESNE YÖNELİMLİ PROGRAMLAMA PRENSİPLERİ:
 * ---------------------------------------------------------------------
 * 1. ABSTRACTION (Soyutlama):
 *    - Vehicle sınıfı abstract olduğu için doğrudan nesne oluşturulamaz
 *    - Alt sınıflar (Sedan, SUV) somut implementasyonları sağlar
 * 
 * 2. INHERITANCE (Kalıtım):
 *    - Alt sınıflar brand, model, dailyRate özelliklerini miras alır
 *    - getDetails() ve getCost() metotları override edilebilir
 * 
 * 3. ENCAPSULATION (Kapsülleme):
 *    - protected erişim belirleyicisi sayesinde özellikler
 *      sadece alt sınıflardan erişilebilir
 * 
 * @author Emre
 * @version 1.0
 */
package core;

/**
 * Tüm araç tiplerinin türediği soyut temel sınıf
 * 
 * Rentable arayüzünü implemente ederek:
 * - Decorator pattern'de Component rolünü üstlenir
 */
abstract class Vehicle implements Rentable {

    /**
     * Araç markası (örn: Mercedes, BMW, Tesla)
     */
    protected String brand;

    /**
     * Araç modeli (örn: C200, X5, Model S)
     */
    protected String model;

    /**
     * Günlük kiralama ücreti (TL cinsinden)
     */
    protected double dailyRate;

    /**
     * Araç Constructor (Yapıcı Metot)
     * @param brand     Araç markası
     * @param model     Araç modeli
     * @param dailyRate Günlük kiralama ücreti
     */
    public Vehicle(String brand, String model, double dailyRate) {
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
    }

    /**
     * Araç detaylarını string olarak döndürür
     * 
     * @Override: Rentable arayüzündeki metodu implement eder
     *            Alt sınıflar bu metodu override ederek tip bilgisi ekleyebilir
     * 
     * @return "marka model" formatında araç bilgisi (örn: "Mercedes C200")
     */
    @Override
    public String getDetails() {
        return brand + " " + model;
    }

    /**
     * Günlük kiralama ücretini döndürür
     * @return Temel günlük ücret (decorator eklemeleri hariç)
     */
    @Override
    public double getCost() {
        return dailyRate;
    }
}
