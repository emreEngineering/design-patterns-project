package core;

// --- ORTAK ARAYÜZ ---
// Tüm araçların ve eklentilerin atası
public interface Rentable {
    String getDetails(); // Araç bilgisini getir

    double getCost();    // Fiyatı getir
}
