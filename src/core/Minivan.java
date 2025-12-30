package core;

/**
 * Minivan (aile aracı) sınıfı
 */
public class Minivan extends Vehicle {

    /**
     * Minivan Constructor (Yapıcı Metot)
     * 
     * @param brand Marka (örn: Volkswagen, Mercedes, Ford)
     * @param model Model (örn: Transporter, Vito, Tourneo)
     * @param price Günlük kiralama ücreti (TL)
     */
    public Minivan(String brand, String model, double price) {

        super(brand, model, price);
    }

    /**
     * Minivan'ın detay bilgisini döndürür
     * 
     * "[Van]" etiketi araç tipini belirtir.
     * "(Family Size)" ifadesi geniş aile aracı olduğunu vurgular.
     * 
     * @return "[Van] marka model (Family Size)" formatında string
     */
    @Override
    public String getDetails() {
        return "[Van] " + super.getDetails() + " (Family Size)";
    }
}
