package structural;

/*
 * ==============================================================================
 *                     LEGACY BANK API (Eski Banka API'si)
 *                        Adaptee - Uyarlanacak Sınıf
 * ==============================================================================
 * 
 * BU SINIF NEDİR?
 * ---------------
 * Bu, değiştiremediğimiz (veya değiştirmememiz gereken) eski bir sistemdir.
 * Gerçek hayatta bu bir 3rd party kütüphane veya harici servis olabilir.
 * 
 * SENARYO:
 * --------
 * - Şirketimiz modern bir sistem kullanıyor: process(amount)
 * - Çalıştığımız banka eski bir API sunuyor: transferFunds(amt)
 * - Bankanın kodunu değiştiremeyiz (dışarıdan geliyor)
 * - Bizim kodumuzu da değiştirmek istemiyoruz (çok yerde kullanılıyor)
 * 
 * ADAPTEE (Uyarlanacak Sınıf) ÖZELLİKLERİ:
 * ----------------------------------------
 * - Mevcut, çalışan kod
 * - Değiştirilemez (3rd party, legacy, veya çok riskli)
 * - Farklı arayüze sahip (metodlar, parametreler)
 * 
 * GERÇEK HAYAT ÖRNEKLARI:
 * -----------------------
 * - Eski SOAP servisi, modern REST API'ye adapte edilir
 * - Java Stream API, legacy Iterator'a adapte edilir
 * - Farklı ülkelerin elektrik prizi adaptörleri
 */
class LegacyBankApi {

    /**
     * Eski bankanın para transfer metodu.
     * 
     * DİKKAT: Bu metodun adı ve yapısı bizim sistemimizden farklı!
     * - Bizim sistemimiz: process(double amount)
     * - Bankanın sistemi: transferFunds(double amt)
     * 
     * @param amt Transfer edilecek miktar (USD cinsinden - bu bile farklı
     *            olabilir!)
     * 
     *            NOT: Gerçek implementasyonda burada:
     *            - Banka API'sine HTTP isteği gönderilir
     *            - Güvenlik kontrolü yapılır
     *            - Transaction kaydı tutulur
     */
    public void transferFunds(double amt) {
        System.out.println("Miras Bankası: Transfer Edildi" + amt + " USD.");
    }
}
