package core;

/*
 * ==============================================================================
 *                           VEHICLE (ABSTRACT CLASS)
 *                    Soyut Araç Sınıfı - Tüm Araçların Atası
 * ==============================================================================
 * 
 * ABSTRACT CLASS NEDİR?
 * ----------------------
 * Abstract (soyut) sınıf, doğrudan nesne oluşturulamayan ama miras alınabilen
 * sınıftır. "new Vehicle()" yazamayız ama "new Sedan()" yazabiliriz.
 * 
 * NEDEN ABSTRACT KULLANDIK?
 * -------------------------
 * 1. Ortak Davranış: Tüm araçların brand, model ve dailyRate özelliği var.
 *    Bu ortak kodu her alt sınıfta yazmak yerine burada bir kez yazıyoruz.
 * 
 * 2. Genişletilebilirlik: Alt sınıflar (Sedan, SUV, SportsCar, Minivan)
 *    kendi özel davranışlarını ekleyebilir (örn: getDetails() override).
 * 
 * 3. Template Method Pattern: getDetails() ve getCost() burada tanımlanıyor,
 *    alt sınıflar gerektiğinde override edebilir.
 * 
 * SINIF HİYERARŞİSİ:
 * ------------------
 *                    Rentable (Interface)
 *                         |
 *                    Vehicle (Abstract)
 *                    /    |    \     \
 *               Sedan   SUV  SportsCar  Minivan
 * 
 * ÖNEMLİ NOTLAR:
 * --------------
 * - "protected" erişim belirleyicisi: Alt sınıflar bu alanlara erişebilir.
 * - "implements Rentable": Bu sınıf Rentable arayüzünü uygular.
 */
abstract class Vehicle implements Rentable {

    // ==================== ALANLAR (FIELDS) ====================

    /**
     * Aracın markası (örn: "Toyota", "Mercedes", "Porsche")
     * protected: Sadece bu sınıf ve alt sınıflar erişebilir
     */
    protected String brand;

    /**
     * Aracın modeli (örn: "Corolla", "Vito", "911 Carrera")
     */
    protected String model;

    /**
     * Günlük kiralama ücreti (TL cinsinden)
     */
    protected double dailyRate;

    // ==================== CONSTRUCTOR ====================

    /**
     * Vehicle Constructor - Tüm alt sınıflar bu yapıcıyı çağırır.
     * 
     * @param brand     Araç markası
     * @param model     Araç modeli
     * @param dailyRate Günlük kiralama ücreti (TL)
     * 
     *                  Kullanım örneği (alt sınıfta):
     *                  super("Toyota", "Corolla", 1200);
     */
    public Vehicle(String brand, String model, double dailyRate) {
        this.brand = brand; // "this" o anki nesneyi temsil eder
        this.model = model;
        this.dailyRate = dailyRate;
    }

    // ==================== RENTABLE INTERFACE METODLARI ====================

    /**
     * Aracın temel bilgilerini döndürür.
     * Alt sınıflar bu metodu override ederek kendi formatlarını ekleyebilir.
     * 
     * @return "Marka Model" formatında String (örn: "Toyota Corolla")
     */
    @Override
    public String getDetails() {
        return brand + " " + model;
    }

    /**
     * Günlük kiralama ücretini döndürür.
     * 
     * @return Günlük ücret (TL cinsinden)
     */
    @Override
    public double getCost() {
        return dailyRate;
    }
}