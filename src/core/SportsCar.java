package core;

/**
 * Spor araç sınıfı
 */
public class SportsCar extends Vehicle {

    /**
     * SportsCar Constructor (Yapıcı Metot)
     * 
     * @param brand Marka (örn: Ferrari, Lamborghini, Porsche)
     * @param model Model (örn: 488 Spider, Huracán, 911)
     * @param price Günlük kiralama ücreti (TL) - genellikle yüksek
     */
    public SportsCar(String brand, String model, double price) {

        super(brand, model, price);
    }

    /**
     * Spor aracın detay bilgisini döndürür
     * 
     * @return "[Sport] marka model (High Performance)" formatında string
     */
    @Override
    public String getDetails() {
        return "[Sport] " + super.getDetails() + " (High Performance)";
    }
}
