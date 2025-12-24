package core;

// Ortak Arayüz: Tüm araçlar ve eklentiler bu arayüzü kullanır.
public interface Rentable {
    String getDetails(); // Araç açıklaması

    double getCost();    // Günlük ücret
}
