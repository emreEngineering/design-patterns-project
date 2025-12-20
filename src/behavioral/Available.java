package behavioral;

/*
 * ==============================================================================
 *                   CONCRETE STATE - Available
 *                      Somut Durum - Müsait
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * Aracın "Müsait" (Available) durumunu temsil eder.
 * Bu durumdayken yapılabilecek işlemler bu sınıfta tanımlanır.
 * 
 * DURUM GEÇİŞLERİ:
 * ----------------
 *   Available ──rentCar()──→ OnRoad
 *             ←─returnCar()──
 * 
 * AVAILABLE DURUMUNDA:
 * --------------------
 * ✓ rentCar()   : İZİN VERİLİR - Araç kiralanabilir
 * ✗ returnCar() : HATA - Araç zaten garajda, iade edilemez
 * 
 * STATE PATTERN'İN GÜZEL YANI:
 * ----------------------------
 * Her durum kendi kurallarını bilir. Context (VehicleContext):
 * - Hangi durumda olduğunu bilir
 * - İşlemleri mevcut duruma delege eder
 * - If-else yazmaz, durum nesnesi karar verir
 */
class Available implements State {

    /**
     * Kiralama işlemi - BAŞARILI
     * --------------------------
     * Available durumdaki araç kiralanabilir.
     * İşlem sonunda durum OnRoad'a geçer.
     * 
     * @param ctx Context nesnesi (durumu değiştirmek için)
     */
    public void rentCar(VehicleContext ctx) {
        System.out.println("[Status] Araç artık KİRALIKTIR.");

        // DURUM GEÇİŞİ: Available → OnRoad
        // Context'in durumunu "OnRoad" yapıyoruz
        ctx.setCurrentState(new OnRoad());
    }

    /**
     * İade işlemi - HATA
     * ------------------
     * Available durumdaki araç zaten garajda.
     * Tekrar iade edilemez (mantıksız işlem).
     * 
     * @param ctx Context nesnesi (bu durumda kullanılmaz)
     */
    public void returnCar(VehicleContext ctx) {
        System.out.println("[Status] HATA: Araba zaten garajda.");
        // Durum değişmez, Available kalır
    }
}
