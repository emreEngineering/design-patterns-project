package behavioral;

/*
 * ==============================================================================
 *                    CONCRETE STATE - OnRoad
 *                      Somut Durum - Yolda (Kirada)
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * Aracın "Yolda/Kirada" (OnRoad) durumunu temsil eder.
 * Bu durum, aracın bir müşteri tarafından kiralandığını gösterir.
 * 
 * ONROAD DURUMUNDA:
 * -----------------
 * ✗ rentCar()   : HATA - Araç zaten kirada, tekrar kiralanamaz
 * ✓ returnCar() : İZİN VERİLİR - Araç iade edilebilir
 * 
 * DURUM MAKİNESİ (STATE MACHINE):
 * -------------------------------
 *   ┌─────────────────────────────────────────────────────────┐
 *   │                                                         │
 *   │    ┌───────────┐              ┌───────────┐             │
 *   │    │ Available │──rentCar()──▶│  OnRoad   │             │
 *   │    │  (Garaj)  │◀─returnCar()─│  (Yolda)  │             │
 *   │    └───────────┘              └───────────┘             │
 *   │         │                           │                   │
 *   │         │ rentCar(): ✓              │ rentCar(): ✗      │
 *   │         │ returnCar(): ✗            │ returnCar(): ✓    │
 *   │                                                         │
 *   └─────────────────────────────────────────────────────────┘
 * 
 * BU YÖNTEM vs IF-ELSE:
 * ---------------------
 * If-else ile: Her metoda TÜM durumları yazmak gerekir
 * State ile: Her durum sadece KENDİ kurallarını bilir (SRP)
 */
class OnRoad implements State {

    /**
     * Kiralama işlemi - HATA
     * ----------------------
     * OnRoad durumundaki araç zaten kirada.
     * Aynı anda iki kişiye kiralanamaz.
     * 
     * @param ctx Context nesnesi (bu durumda kullanılmaz)
     */
    public void rentCar(VehicleContext ctx) {
        System.out.println("[Status] HATA: Araba zaten yolda!");
        // Durum değişmez, OnRoad kalır
    }

    /**
     * İade işlemi - BAŞARILI
     * ----------------------
     * OnRoad durumundaki araç garaja dönüyor.
     * Hasar kontrolü yapılacağı mesajı verilir.
     * 
     * @param ctx Context nesnesi (durumu değiştirmek için)
     */
    public void returnCar(VehicleContext ctx) {
        System.out.println("[Status] Araba garaja döndü. Hasarlar kontrol ediliyor...");

        // DURUM GEÇİŞİ: OnRoad → Available
        // Araç artık yeniden kiralanabilir
        ctx.setCurrentState(new Available());
    }
}
