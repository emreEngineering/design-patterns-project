package cretional;

import core.*;

/*
 * ==============================================================================
 *                   FACTORY METHOD DESIGN PATTERN - FleetHub
 *                        (Fabrika Metodu Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  FACTORY PATTERN NEDİR?                                                    ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Nesne oluşturma mantığını bir "fabrika" sınıfına taşıyan desendir.        ║
 * ║  İstemci (client) hangi somut sınıfın oluşturulduğunu bilmez.              ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM (Factory Olmadan - Tight Coupling):
 * -------------------------------------------
 * Ana kodda somut sınıf isimleri kullanırsak:
 * 
 *   Rentable car1 = new Sedan("Fiat", "Egea", 800);
 *   Rentable car2 = new SportsCar("Porsche", "911", 5000);
 *   Rentable car3 = new SUV("Range Rover", "Sport", 2500);
 * 
 * Yarın "Tesla" modeli eklersek Main.java'yı değiştirmemiz gerekir!
 * Bu "Sıkı Bağlılık" (Tight Coupling) yaratır.
 * 
 * ÇÖZÜM (Factory ile - Loose Coupling):
 * -------------------------------------
 *   FleetHub garage = new FleetHub();
 *   Rentable car1 = garage.getVehicle("Economy");  // Hangi sınıf? Bilmiyoruz!
 *   Rentable car2 = garage.getVehicle("Luxury");   // Sadece kategori istiyoruz
 *   Rentable car3 = garage.getVehicle("SUV");
 * 
 * Yarın "Tesla" eklemek için:
 * 1. Tesla sınıfı oluştur (Vehicle'dan türet)
 * 2. FleetHub'a "Electric" kategorisi ekle
 * 3. Main.java'ya DOKUNMA! (Gevşek Bağlılık)
 * 
 * FACTORY PATTERN'IN AVANTAJLARI:
 * -------------------------------
 * 1. Loose Coupling: İstemci somut sınıfları bilmez
 * 2. Single Responsibility: Nesne oluşturma tek bir yerde toplanır
 * 3. Open/Closed: Yeni tipler eklemek kolay, mevcut kod değişmez
 * 4. Encapsulation: Oluşturma detayları gizlenir
 * 
 *                    ┌─────────────────┐
 *                    │    FleetHub     │
 *                    │   (Factory)     │
 *                    └────────┬────────┘
 *                             │
 *           ┌─────────────────┼─────────────────┐
 *           │                 │                 │
 *           ▼                 ▼                 ▼
 *      ┌─────────┐      ┌──────────┐     ┌───────────┐
 *      │ Sedan   │      │ SportsCar│     │    SUV    │
 *      └─────────┘      └──────────┘     └───────────┘
 */
public class FleetHub {

    /**
     * FACTORY METHOD (Fabrika Metodu)
     * --------------------------------
     * Kategori adına göre uygun araç nesnesini oluşturur ve döndürür.
     * 
     * İstemci bu metoddan ne döneceğini bilmez, sadece Rentable tipinde
     * bir nesne alacağını bilir. Bu "Program to an interface, not implementation"
     * prensibinin uygulamasıdır.
     * 
     * @param category Araç kategorisi ("Economy", "Comfort", "SUV", "Luxury",
     *                 "Family")
     * @return Rentable tipinde araç nesnesi
     * 
     *         KATEGORİLER VE KARŞILIKLARI:
     *         ----------------------------
     *         - "Economy" -> Sedan (Fiat Egea, 800 TL/gün) : Bütçe dostu
     *         - "Comfort" -> Sedan (Toyota Corolla, 1200 TL) : Konfor odaklı
     *         - "SUV" -> SUV (Range Rover Sport, 2500 TL) : Arazi aracı
     *         - "Luxury" -> SportsCar (Porsche 911, 5000 TL) : Lüks spor
     *         - "Family" -> Minivan (Mercedes Vito, 1800 TL) : Aile aracı
     *         - Diğer -> Sedan (Renault Clio, 600 TL) : Varsayılan
     */
    public Rentable getVehicle(String category) {

        // String karşılaştırmasında equalsIgnoreCase kullanıyoruz
        // Bu sayede "economy", "ECONOMY", "Economy" hepsi çalışır

        if (category.equalsIgnoreCase("Economy")) {
            // En ekonomik seçenek: Fiat Egea
            return new Sedan("Fiat", "Egea", 800);

        } else if (category.equalsIgnoreCase("Comfort")) {
            // Konfor sınıfı: Toyota Corolla
            return new Sedan("Toyota", "Corolla", 1200);

        } else if (category.equalsIgnoreCase("SUV")) {
            // Arazi aracı: Range Rover Sport
            return new SUV("Range Rover", "Sport", 2500);

        } else if (category.equalsIgnoreCase("Luxury")) {
            // Lüks spor: Porsche 911 Carrera
            return new SportsCar("Porsche", "911 Carrera", 5000);

        } else if (category.equalsIgnoreCase("Family")) {
            // Aile aracı: Mercedes Vito (7 koltuk)
            return new Minivan("Mercedes", "Vito", 1800);

        } else {
            // Varsayılan araç: Renault Clio (en ucuz)
            // Tanınmayan kategoriler için güvenli bir seçenek
            return new Sedan("Renault", "Clio", 600);
        }
    }

    /*
     * GELİŞTİRME ÖNERİSİ:
     * -------------------
     * Gerçek projede if-else yerine Strategy veya Map kullanılabilir:
     * 
     * private Map<String, Supplier<Rentable>> vehicles = Map.of(
     * "Economy", () -> new Sedan("Fiat", "Egea", 800),
     * "Luxury", () -> new SportsCar("Porsche", "911", 5000)
     * );
     * 
     * public Rentable getVehicle(String category) {
     * return vehicles.getOrDefault(category, () -> new Sedan(...)).get();
     * }
     */
}