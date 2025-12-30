package core;

/**
 * SUV tipi araç sınıfı
 */
public class SUV extends Vehicle {

    /**
     * SUV Constructor (Yapıcı Metot)
     * 
     * @param brand Marka (örn: Range Rover, BMW, Mercedes)
     * @param model Model (örn: Vogue, X5, GLE)
     * @param price Günlük kiralama ücreti (TL)
     */
    public SUV(String brand, String model, double price) {
        // Üst sınıfın (Vehicle) yapıcısını çağır
        super(brand, model, price);
    }

    /**
     * SUV'un detay bilgisini döndürür
     * 
     * @return "[SUV] marka model (Off-Road)" formatında string
     */
    @Override
    public String getDetails() {
        return "[SUV] " + super.getDetails() + " (Off-Road)";
    }
}
