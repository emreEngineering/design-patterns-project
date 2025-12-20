package behavioral;

/*
 * ==============================================================================
 *                    CONTEXT CLASS - VehicleContext
 *                         Bağlam Sınıfı - Araç Durumu
 * ==============================================================================
 * 
 * BU SINIF NE YAPAR?
 * ------------------
 * State pattern'daki "Context" (Bağlam) rolünü üstlenir.
 * Mevcut durumu tutar ve işlemleri duruma delege eder.
 * 
 * CONTEXT'İN SORUMLULUKLARI:
 * --------------------------
 * 1. Mevcut State nesnesini tutmak (currentState)
 * 2. Durum değişikliklerine izin vermek (setCurrentState)
 * 3. İşlemleri mevcut duruma yönlendirmek (delegation)
 * 
 * KULLANIM ÖRNEĞİ:
 * ----------------
 *   VehicleContext car = new VehicleContext(); // Başlangıç: Available
 *   
 *   car.requestRent();   // [Status] Araç artık KİRALIKTIR.
 *                        // -> Durum: OnRoad
 *   
 *   car.requestRent();   // [Status] HATA: Araba zaten yolda!
 *                        // -> Durum değişmez (hala OnRoad)
 *   
 *   car.requestReturn(); // [Status] Araba garaja döndü...
 *                        // -> Durum: Available
 *   
 *   car.requestRent();   // [Status] Araç artık KİRALIKTIR.
 *                        // -> Durum: OnRoad
 * 
 * DELEGATION (YETKİ DEVRİ):
 * -------------------------
 *   İstemci                Context                    State
 *     │                       │                         │
 *     ├──requestRent()───────▶│                         │
 *     │                       ├──rentCar(this)─────────▶│
 *     │                       │                         │
 *     │                       │◀────setCurrentState()───┤
 *     │◀──────────────────────┤                         │
 * 
 * NOT: Bu dosyada Decorator ve Adapter pattern'lerin referansları var
 * çünkü dosya başlangıçta onların açıklamalarını içeriyordu.
 * Gerçekte VehicleContext tamamen State pattern'a aittir.
 */

// [4] DECORATOR -> structural.FeatureAddon
// Araca dinamik özellik ekler (GPS, Koltuk vb.)

// [5] ADAPTER -> structural.PaymentGateway
// Eski banka sistemini bizim sistemimize entegre eder.

/**
 * CONTEXT (Bağlam) Sınıfı
 * -----------------------
 * Aracın mevcut durumunu yöneten ana sınıf.
 */
public class VehicleContext {

    /**
     * MEVCUT DURUM (Current State)
     * ----------------------------
     * Aracın şu anki durumunu tutar.
     * Bu değişken üzerinden tüm davranışlar belirlenir.
     * 
     * Olası değerler:
     * - new Available() : Araç garajda, kiralanabilir
     * - new OnRoad() : Araç yolda, kirada
     */
    private State currentState;

    /**
     * VehicleContext Constructor
     * --------------------------
     * Araç oluşturulduğunda varsayılan durum "Available" (Müsait) olur.
     * Yeni araçlar garajda başlar.
     */
    public VehicleContext() {
        // Başlangıç durumu: Müsait
        this.currentState = new Available();
    }

    /**
     * DURUM DEĞİŞTİRME (State Transition)
     * -----------------------------------
     * State nesneleri tarafından çağrılır.
     * Durum geçişlerini mümkün kılar.
     * 
     * @param s Yeni durum nesnesi
     * 
     *          ÖNEMLİ: Bu metod sadece State sınıfları tarafından çağrılmalıdır!
     *          Dışarıdan durumu manuel değiştirmek State pattern'ı bozar.
     */
    public void setCurrentState(State s) {
        this.currentState = s;
    }

    /**
     * KİRALAMA TALEBİ (Rent Request)
     * ------------------------------
     * Dışarıya sunulan arayüz metodu.
     * İşlemi mevcut duruma delege eder.
     * 
     * Çalışma mantığı:
     * - Eğer durum Available ise → Kiralama başarılı, durum OnRoad olur
     * - Eğer durum OnRoad ise → HATA, araç zaten kirada
     */
    public void requestRent() {
        // Mevcut durumun rentCar() metodunu çağır
        // "this" gönderiyoruz ki durum değiştirilebilsin
        currentState.rentCar(this);
    }

    /**
     * İADE TALEBİ (Return Request)
     * ----------------------------
     * Dışarıya sunulan arayüz metodu.
     * İşlemi mevcut duruma delege eder.
     * 
     * Çalışma mantığı:
     * - Eğer durum OnRoad ise → İade başarılı, durum Available olur
     * - Eğer durum Available ise → HATA, araç zaten garajda
     */
    public void requestReturn() {
        // Mevcut durumun returnCar() metodunu çağır
        currentState.returnCar(this);
    }
}