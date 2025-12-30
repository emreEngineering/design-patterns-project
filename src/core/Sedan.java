package core;

/**
 * Sedan tipi araç sınıfı
 */
public class Sedan extends Vehicle {

    /**
     * Sedan Constructor (Yapıcı Metot)
     *
     * @param brand Marka (örn: Mercedes, BMW, Audi)
     * @param model Model (örn: C200, 320i, A4)
     * @param price Günlük kiralama ücreti (TL)
     */
    public Sedan(String brand, String model, double price) {

        super(brand, model, price);
    }

    /**
     * Sedan'ın detay bilgisini döndürür
     * 
     * @return Tip etiketi + marka model + özellik açıklaması
     */
    @Override
    public String getDetails() {
        return "[Sedan] " + super.getDetails() + " (Konfor)";
    }
}
