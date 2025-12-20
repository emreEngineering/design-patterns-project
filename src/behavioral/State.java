package behavioral;

/*
 * ==============================================================================
 *                    STATE DESIGN PATTERN - State Interface
 *                         (Durum Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  STATE PATTERN NEDİR?                                                      ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Bir nesnenin iç DURUMUNA göre DAVRANIŞINI değiştiren desendir.            ║
 * ║  If-else spaghetti'sinden kurtarır.                                        ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM (State Olmadan):
 * ------------------------
 * Araç durumunu if-else ile kontrol edersek:
 * 
 *   void rentCar(String status) {
 *       if (status.equals("Available")) {
 *           this.status = "OnRoad";
 *           System.out.println("Araç kiralandı.");
 *       } else if (status.equals("OnRoad")) {
 *           System.out.println("HATA: Araç zaten yolda!");
 *       } else if (status.equals("UnderMaintenance")) {
 *           System.out.println("HATA: Araç bakımda!");
 *       } else if (status.equals("Reserved")) {
 *           System.out.println("HATA: Araç rezerveli!");
 *       }
 *   }
 * 
 * SORUNLAR:
 * - If-else güçlükle büyür
 * - Her yeni durum için TÜM metodları güncellemek gerekir
 * - Hata yapma riski yüksek
 * 
 * ÇÖZÜM (State Pattern ile):
 * --------------------------
 * Her durum kendi sınıfı olur ve kendi davranışını içerir:
 * 
 *   VehicleContext car = new VehicleContext(); // Başlangıç: Available
 *   car.requestRent();   // "Araç artık KİRALIKTIR." - Durum: OnRoad oldu
 *   car.requestRent();   // "HATA: Araba zaten yolda!" - OnRoad durumu engelliyor
 *   car.requestReturn(); // "Araba garaja döndü." - Durum: Available oldu
 * 
 * STATE PATTERN YAPISI:
 * ---------------------
 *            ┌─────────────────────┐
 *            │   VehicleContext    │ ← Context (Bağlam)
 *            │ ─────────────────── │
 *            │  currentState: State│ ← Mevcut durumu tutar
 *            │ ─────────────────── │
 *            │  + requestRent()    │ ← State'e delege eder
 *            │  + requestReturn()  │
 *            └─────────┬───────────┘
 *                      │ has-a
 *                      ▼
 *            ┌─────────────────────┐
 *            │       State         │ ← State Interface
 *            │   (Interface)       │
 *            │ ─────────────────── │
 *            │  + rentCar(ctx)     │
 *            │  + returnCar(ctx)   │
 *            └─────────┬───────────┘
 *                      │
 *         ┌────────────┴────────────┐
 *         ▼                         ▼
 *   ┌───────────────┐       ┌───────────────┐
 *   │   Available   │       │    OnRoad     │
 *   │ ───────────── │       │ ───────────── │
 *   │ rentCar() ✓   │       │ rentCar() ✗   │
 *   │ returnCar() ✗ │       │ returnCar() ✓ │
 *   └───────────────┘       └───────────────┘
 */
interface State {

    /**
     * Kiralama talebi işleme metodu.
     * 
     * @param ctx VehicleContext (durumu değiştirmek için referans)
     * 
     *            DURUMLARA GÖRE DAVRANIŞ:
     *            - Available: Kiralama başarılı → Durum OnRoad olur
     *            - OnRoad: HATA - Araç zaten yolda
     */
    void rentCar(VehicleContext ctx);

    /**
     * İade talebi işleme metodu.
     * 
     * @param ctx VehicleContext (durumu değiştirmek için referans)
     * 
     *            DURUMLARA GÖRE DAVRANIŞ:
     *            - Available: HATA - Araç zaten garajda
     *            - OnRoad: İade başarılı → Durum Available olur
     */
    void returnCar(VehicleContext ctx);
}
