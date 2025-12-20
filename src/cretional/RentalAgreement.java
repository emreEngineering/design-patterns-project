package cretional;

import core.Rentable;

/*
 * ==============================================================================
 *                    BUILDER DESIGN PATTERN - RentalAgreement
 *                        (İnşaatçı Tasarım Deseni)
 * ==============================================================================
 * 
 * ╔════════════════════════════════════════════════════════════════════════════╗
 * ║  BUILDER PATTERN NEDİR?                                                    ║
 * ╠════════════════════════════════════════════════════════════════════════════╣
 * ║  Karmaşık nesneleri ADIM ADIM oluşturmamızı sağlayan desendir.             ║
 * ║  Özellikle çok sayıda parametre olan nesnelerde kullanılır.                ║
 * ╚════════════════════════════════════════════════════════════════════════════╝
 * 
 * PROBLEM (Builder Olmadan - Telescoping Constructor):
 * ----------------------------------------------------
 * Bir kira sözleşmesinde birçok parametre olabilir:
 * 
 *   new RentalAgreement(
 *       "Ali Veli",           // Müşteri adı
 *       car,                  // Araç
 *       5,                    // Gün sayısı
 *       true,                 // Sigorta var mı?
 *       false,                // Ek şoför var mı?
 *       true,                 // Bebek koltuğu?
 *       "İstanbul",           // Teslim şehri
 *       "Ankara"              // İade şehri
 *   );
 * 
 * SORUNLAR:
 * - Parametre sırası hataya açık (true ve false yer değiştirebilir)
 * - Kod okunaklı değil (hangi true hangisi?)
 * - Opsiyonel parametreler için overload gerekir
 * 
 * ÇÖZÜM (Builder ile - Fluent API):
 * ---------------------------------
 *   RentalAgreement contract = new RentalAgreement.Draft("Ali Veli", car, 5)
 *       .addFullCoverage()     // Sigorta ekle
 *       .addExtraDriver()      // Ek şoför ekle (opsiyonel)
 *       .setPickupCity("İst")  // Teslim şehri (opsiyonel)
 *       .sign();               // Sözleşmeyi oluştur
 * 
 * AVANTAJLAR:
 * - Okunabilir kod (her adım açık)
 * - Opsiyonel parametreler kolayca eklenir/çıkarılır
 * - İmmutable (değişmez) nesne oluşturulabilir
 * - Method chaining (zincirleme) ile akıcı yazım
 * 
 * BUILDER PATTERN YAPISI:
 * -----------------------
 *   ┌────────────────────────────────────────────────────────┐
 *   │                   RentalAgreement                      │
 *   │ ─────────────────────────────────────────────────────  │
 *   │  - customerName: String                                │
 *   │  - car: Rentable                                       │
 *   │  - days: int                                           │
 *   │  - insuranceIncluded: boolean                          │
 *   │ ─────────────────────────────────────────────────────  │
 *   │  - RentalAgreement(Draft) [private constructor]        │
 *   │  + print(): void                                       │
 *   │                                                        │
 *   │  ┌──────────────────────────────────────────────────┐  │
 *   │  │              Draft (Inner Class)                 │  │
 *   │  │ ───────────────────────────────────────────────  │  │
 *   │  │  - customerName, car, days, insuranceIncluded    │  │
 *   │  │ ───────────────────────────────────────────────  │  │
 *   │  │  + Draft(name, car, days)                        │  │
 *   │  │  + addFullCoverage(): Draft                      │  │
 *   │  │  + sign(): RentalAgreement                       │  │
 *   │  └──────────────────────────────────────────────────┘  │
 *   └────────────────────────────────────────────────────────┘
 */
public class RentalAgreement {

    // ==================== ÜRÜN ALANLARI (Product Fields) ====================

    /**
     * Müşteri adı (sözleşme sahibi)
     */
    private String customerName;

    /**
     * Kiralanan araç (Rentable tipinde - polymorphism)
     */
    private Rentable car;

    /**
     * Kiralama süresi (gün cinsinden)
     */
    private int days;

    /**
     * Tam kapsamlı sigorta dahil mi?
     */
    private boolean insuranceIncluded;

    // ==================== PRIVATE CONSTRUCTOR ====================

    /**
     * GİZLİ CONSTRUCTOR (Private Constructor)
     * ----------------------------------------
     * Bu constructor sadece Draft (Builder) sınıfı tarafından çağrılabilir.
     * Dışarıdan doğrudan "new RentalAgreement(...)" yazılamaz.
     * 
     * Bu sayede:
     * 1. Nesne SADECE Builder üzerinden oluşturulabilir
     * 2. Tüm alanlar constructor'da set edilir (immutability)
     * 3. Yarım kalmış nesne oluşturma riski ortadan kalkar
     * 
     * @param draft Builder nesnesi (tüm değerleri içerir)
     */
    private RentalAgreement(Draft draft) {
        // Builder'daki değerleri ürüne kopyala
        this.customerName = draft.customerName;
        this.car = draft.car;
        this.days = draft.days;
        this.insuranceIncluded = draft.insuranceIncluded;
    }

    // ==================== ÜRÜN METODLARI ====================

    /**
     * Sözleşme detaylarını ekrana yazdırır.
     * Gerçek projede bu PDF oluşturma veya database'e kayıt olabilir.
     */
    public void print() {
        System.out.println("[Agreement] Sözleşme imzalandı " + customerName +
                ". Araç: " + car.getDetails() +
                " | Gün: " + days +
                " | Sigorta: " + (insuranceIncluded ? "Evet" : "Hayır"));
    }

    // ==================== BUILDER (İNŞAATÇI) SINIFI ====================

    /**
     * DRAFT (Taslak) - Builder Sınıfı
     * ================================
     * Bu iç sınıf (inner class) RentalAgreement'ı adım adım oluşturur.
     * "Draft" (Taslak) olarak isimlendirdik çünkü sözleşme imzalanana kadar
     * taslak halindedir.
     * 
     * FLUENT API:
     * -----------
     * Her metod "this" döndürür, bu sayede method chaining yapılabilir:
     * new Draft(...).addFullCoverage().sign();
     * 
     * STATIC INNER CLASS:
     * -------------------
     * Static yapıldı çünkü RentalAgreement nesnesi olmadan da
     * Draft oluşturabilmemiz gerekiyor.
     */
    public static class Draft {

        // Builder'ın geçici olarak tuttuğu değerler
        private String customerName;
        private Rentable car;
        private int days;
        private boolean insuranceIncluded;

        /**
         * Draft Constructor - Zorunlu Parametreler
         * -----------------------------------------
         * Builder pattern'da zorunlu parametreler genellikle
         * constructor'da alınır.
         * 
         * @param customerName Müşteri adı (zorunlu)
         * @param car          Araç (zorunlu)
         * @param days         Gün sayısı (zorunlu)
         */
        public Draft(String customerName, Rentable car, int days) {
            this.customerName = customerName;
            this.car = car;
            this.days = days;
            // insuranceIncluded varsayılan olarak false
        }

        /**
         * Tam kapsamlı sigorta ekler.
         * 
         * FLUENT API: "this" döndürerek zincirleme çağrı sağlar.
         * 
         * Kullanım:
         * new Draft(...).addFullCoverage().sign();
         * 
         * @return Builder nesnesi (method chaining için)
         */
        public Draft addFullCoverage() {
            this.insuranceIncluded = true;
            return this; // Zincirleme için kendini döndür
        }

        /*
         * EKLENEBİLECEK DİĞER METODLAR:
         * -----------------------------
         * public Draft addExtraDriver() { ... return this; }
         * public Draft addChildSeat() { ... return this; }
         * public Draft setPickupLocation(String city) { ... return this; }
         * public Draft setReturnLocation(String city) { ... return this; }
         */

        /**
         * SÖZLEŞMEYİ İMZALA (Build Metodu)
         * ---------------------------------
         * Builder pattern'ın son adımıdır. Tüm ayarlar yapıldıktan sonra
         * çağrılır ve nihai ürünü (RentalAgreement) oluşturur.
         * 
         * @return Tamamlanmış RentalAgreement nesnesi
         */
        public RentalAgreement sign() {
            // RentalAgreement'ın private constructor'ını çağır
            // Bu metod dışından kimse bu constructor'a erişemez
            return new RentalAgreement(this);
        }
    }
}
