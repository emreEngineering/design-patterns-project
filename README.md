# Araç Kiralama Sistemi - Tasarım Desenleri Projesi

Bu proje, **Yazılım Tasarım Desenleri** dersi kapsamında hazırlanmış bir Java uygulamasıdır.
Amaç; gerçek hayata yakın bir araç kiralama senaryosu üzerinden farklı tasarım desenlerinin birlikte nasıl kullanılabildiğini göstermektir.

## Projenin Amacı

Uygulama; araç üretimi, araçlara ek özellik tanımlama, fiyatlandırma, bildirim gönderme ve kiralama akışını yönetme gibi adımları bir araya getirir.
Bu süreçte, farklı sorumluluklar uygun tasarım desenleriyle ayrıştırılmıştır.

Projede toplam **6 tasarım deseni** kullanılmaktadır:

1. **Singleton** - `SystemConfig`
2. **Factory Method** - `FleetHub`
3. **Decorator** - `CarDecorator` ve türevleri
4. **Strategy** - `PricingPolicy` ve indirim stratejileri
5. **Observer** - `NotificationSystem` ve abone yapısı
6. **Facade** - `RentalService`

## Proje Yapısı

```text
src/
├── Main.java                  # Demo senaryoları ve uygulama giriş noktası
├── core/                      # Temel alan sınıfları (araçlar ve arayüzler)
├── creational/                # Yaratımsal desenler (Singleton, Factory)
├── structural/                # Yapısal desenler (Decorator, Facade)
└── behavioral/                # Davranışsal desenler (Strategy, Observer)
```

## Çalışma Mantığı (Özet)

- `FleetHub`, istenen tipte araç nesnesini üretir.
- Decorator sınıfları, araca dinamik olarak ekstra özellik ekler (GPS, şoför, çocuk koltuğu vb.).
- `RentalService`, kiralama akışını tek noktadan yönetir.
- Fiyat hesaplama, seçilen stratejiye göre yapılır (`NORMAL`, `HOLIDAY`, `VIP`).
- Observer yapısı ile müşterilere kiralama bildirimleri gönderilir.

## Gereksinimler

- Java 8 veya üzeri
- Komut satırından `javac` ve `java` erişimi

## Projeyi Çalıştırma

Proje kök dizininde aşağıdaki komutları çalıştırın:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Demo Senaryoları

`Main.java` içinde 3 örnek senaryo çalıştırılır:

1. **Aile Tatili** (Minivan + çocuk koltuğu + kış lastiği, tatil indirimi)
2. **VIP İş Adamı** (Elektrikli araç + şoför + GPS, VIP indirimi)
3. **Genç Çift** (Spor araç + açılır tavan, normal fiyat)

Bu senaryolar sayesinde desenlerin tek tek değil, birlikte nasıl çalıştığı gösterilir.

## Not

Bu proje eğitim amaçlıdır ve tasarım desenlerinin anlaşılmasını kolaylaştırmak için sade tutulmuştur.
