# 🚗 Araç Kiralama Sistemi - Tasarım Desenleri Projesi

## 📋 Proje Özeti

Bu proje, **6 farklı yazılım tasarım deseninin** gerçek dünya senaryolarında nasıl kullanılacağını gösteren bir **araç kiralama sistemi** simülasyonudur. Proje, Java dilinde geliştirilmiş olup, nesne yönelimli programlama prensiplerini (OOP) ve SOLID ilkelerini uygulamaktadır.

### 🎯 Projenin Amacı

- Yazılım tasarım desenlerinin pratik kullanımını göstermek
- Karmaşık iş süreçlerini yönetilebilir modüler yapıya dönüştürmek
- Nesne yönelimli programlama prensiplerini uygulamak
- Kod tekrarını azaltmak ve bakım kolaylığı sağlamak

---

## 📁 Proje Yapısı

```
DesignPatternsProject/
├── src/
│   ├── Main.java                    # Ana uygulama sınıfı
│   ├── core/                        # Temel araç sınıfları
│   │   ├── Rentable.java            # Kiralanabilir nesne arayüzü
│   │   ├── Vehicle.java             # Soyut araç sınıfı
│   │   ├── Sedan.java               # Sedan araç tipi
│   │   ├── SUV.java                 # SUV araç tipi
│   │   ├── SportsCar.java           # Spor araç tipi
│   │   ├── Minivan.java             # Aile aracı tipi
│   │   └── ElectricCar.java         # Elektrikli araç tipi
│   ├── creational/                  # Yaratımsal desenler
│   │   ├── SystemConfig.java        # Singleton Pattern
│   │   └── FleetHub.java            # Factory Method Pattern
│   ├── structural/                  # Yapısal desenler
│   │   ├── CarDecorator.java        # Decorator Pattern (Soyut)
│   │   ├── WithGPS.java             # GPS eklentisi
│   │   ├── WithChildSeat.java       # Çocuk koltuğu eklentisi
│   │   ├── WithChauffeur.java       # Şoför eklentisi
│   │   ├── WithSunroof.java         # Açılır tavan eklentisi
│   │   ├── WithWinterTires.java     # Kış lastiği eklentisi
│   │   └── RentalService.java       # Facade Pattern
│   └── behavioral/                  # Davranışsal desenler
│       ├── PricingPolicy.java       # Strategy Pattern (Arayüz)
│       ├── NormalPrice.java         # Normal fiyat stratejisi
│       ├── VipDiscount.java         # VIP indirim stratejisi
│       ├── HolidayDiscount.java     # Tatil indirim stratejisi
│       ├── Subscriber.java          # Observer Pattern (Arayüz)
│       ├── Customer.java            # Müşteri abone sınıfı
│       └── NotificationSystem.java  # Bildirim sistemi
└── README.md                        # Bu dosya
```

---

## 🎨 Kullanılan Tasarım Desenleri

### 1. 🔒 Singleton Pattern (Tekil Desen)
**Dosya:** `creational/SystemConfig.java`

**Amaç:** Tüm uygulama boyunca sadece BİR TANE nesne oluşturulmasını garanti eder.

**Kullanım Senaryosu:** Veritabanı bağlantısı ve sistem konfigürasyonu yönetimi.

**Çözülen Problem:** 
- Her işlemde yeni bağlantı nesnesi oluşturulması kaynak israfına yol açar
- Sistem ayarlarının her yerden erişilebilir olması gerekir

**Nasıl Çalışır:**
```java
// Private constructor - dışarıdan new yapılamaz
private SystemConfig() { }

// Static instance - tek nesne
private static SystemConfig instance;

// Global erişim noktası
public static SystemConfig getInstance() {
    if (instance == null) {
        instance = new SystemConfig();  // Lazy initialization
    }
    return instance;
}

// Kullanım
SystemConfig.getInstance().connectDB();
```

**Temel Özellikler:**
- Private constructor (dışarıdan nesne oluşturulamaz)
- Static instance değişkeni
- Lazy initialization (ilk çağrıda oluşturulur)

---

### 2. 🏭 Factory Method Pattern (Fabrika Metodu Deseni)
**Dosya:** `creational/FleetHub.java`

**Amaç:** Nesne oluşturma mantığını merkezi bir yerde toplar, istemci kodu somut sınıfları bilmek zorunda kalmaz.

**Kullanım Senaryosu:** Müşteriye araç tahsis etme süreci.

**Çözülen Problem:**
- Kodda `new Mercedes()`, `new Tesla()` gibi doğrudan sınıf isimleri kullanılması sıkı bağlılık yaratır
- Yeni araç tipi eklendiğinde tüm kodun değişmesi gerekir

**Nasıl Çalışır:**
```java
public Rentable createVehicle(String type) {
    switch (type.toUpperCase()) {
        case "SUV":      return new SUV("Range Rover", "Vogue", 3000);
        case "SEDAN":    return new Sedan("Mercedes", "C200", 1500);
        case "SPORT":    return new SportsCar("Ferrari", "488 Spider", 5000);
        case "FAMILY":   return new Minivan("Volkswagen", "Transporter", 1200);
        case "ELECTRIC": return new ElectricCar("Tesla", "Model S", 2500);
        default:         return new Sedan("Fiat", "Egea", 800);
    }
}

// Kullanım
FleetHub factory = new FleetHub();
Rentable car = factory.createVehicle("SPORT");  // Ferrari 488 Spider döner
```

**Avantajları:**
- Gevşek bağlılık (Loose Coupling)
- Open/Closed Principle'a uygun
- Merkezi kontrol

---

### 3. 🎁 Decorator Pattern (Süsleyici Desen)
**Dosyalar:** `structural/CarDecorator.java`, `WithGPS.java`, `WithChildSeat.java`, vb.

**Amaç:** Nesneye çalışma zamanında yeni davranışlar ekler, kalıtım yerine kompozisyon kullanır.

**Kullanım Senaryosu:** Araca GPS, çocuk koltuğu, şoför gibi ek özellikler ekleme.

**Çözülen Problem:**
- Kalıtım ile `SedanWithGPS`, `SedanWithGPSAndChildSeat` gibi kombinasyonlar sınıf patlamasına yol açar
- Her kombinasyon için yeni sınıf gerekir

**Nasıl Çalışır:**
```java
// Temel araç oluştur
Rentable car = factory.createVehicle("FAMILY");  // 1200 TL/gün

// Dinamik olarak özellik ekle (sarmalama)
car = new WithChildSeat(car);   // +100 TL → 1300 TL
car = new WithGPS(car);         // +50 TL  → 1350 TL

// Sonuç: Minivan + Çocuk Koltuğu + GPS
System.out.println(car.getDetails());  // "[Van] VW Transporter + Baby Seat + GPS"
System.out.println(car.getCost());     // 1350.0
```

**Zincirleme Sarmalama:**
```
WithGPS.getCost()
  → WithChildSeat.getCost() + 50
    → Minivan.getCost() + 100 + 50
      → 1200 + 100 + 50 = 1350 TL
```

**Mevcut Dekoratörler:**

| Dekoratör | Ek Ücret | Açıklama |
|-----------|----------|----------|
| WithGPS | +50 TL | GPS navigasyon sistemi |
| WithChildSeat | +100 TL | Bebek/çocuk koltuğu |
| WithChauffeur | +500 TL | Özel şoför hizmeti |
| WithSunroof | +150 TL | Açılır tavan |
| WithWinterTires | +80 TL | Kış lastiği |

---

### 4. 📊 Strategy Pattern (Strateji Deseni)
**Dosyalar:** `behavioral/PricingPolicy.java`, `NormalPrice.java`, `VipDiscount.java`, `HolidayDiscount.java`

**Amaç:** Algoritma ailesini tanımlar ve algoritmayı çalışma zamanında değiştirmeyi sağlar.

**Kullanım Senaryosu:** Müşteri tipine göre farklı fiyatlandırma stratejileri uygulama.

**Çözülen Problem:**
- `if-else` ile fiyat hesaplama kodu kirletir ve yönetilemez kılar
- Yeni indirim tipi eklemek için mevcut kodun değişmesi gerekir

**Nasıl Çalışır:**
```java
// Strateji arayüzü
public interface PricingPolicy {
    double calculate(double price);
}

// Somut stratejiler
public class NormalPrice implements PricingPolicy {
    public double calculate(double price) { return price * 1.0; }  // İndirim yok
}

public class VipDiscount implements PricingPolicy {
    public double calculate(double price) { return price * 0.7; }  // %30 indirim
}

public class HolidayDiscount implements PricingPolicy {
    public double calculate(double price) { return price * 0.8; }  // %20 indirim
}

// Kullanım (çalışma zamanında strateji seçimi)
PricingPolicy policy;
if (customerType.equals("VIP")) {
    policy = new VipDiscount();
} else if (customerType.equals("HOLIDAY")) {
    policy = new HolidayDiscount();
} else {
    policy = new NormalPrice();
}

double finalPrice = policy.calculate(basePrice);
```

**Mevcut Stratejiler:**

| Strateji | İndirim Oranı | Hesaplama |
|----------|---------------|-----------|
| NormalPrice | %0 | fiyat × 1.0 |
| HolidayDiscount | %20 | fiyat × 0.8 |
| VipDiscount | %30 | fiyat × 0.7 |

---

### 5. 👀 Observer Pattern (Gözlemci Deseni)
**Dosyalar:** `behavioral/Subscriber.java`, `Customer.java`, `NotificationSystem.java`

**Amaç:** Nesneler arasında bir-çok (one-to-many) bağımlılık tanımlar, bir nesne değiştiğinde tüm bağımlıları bilgilendirilir.

**Kullanım Senaryosu:** Kiralama işlemi tamamlandığında müşteriye bildirim gönderme.

**Çözülen Problem:**
- Müşterilerin sürekli "araç hazır mı?" diye sorması (polling) sunucuyu yorar
- Bildirim mantığının dağınık olması bakımı zorlaştırır

**Nasıl Çalışır:**
```java
// Subscriber (Abone) arayüzü
interface Subscriber {
    void notifyUser(String msg);
}

// Somut abone
public class Customer implements Subscriber {
    private String name;
    
    public void notifyUser(String msg) {
        System.out.println("SMS to " + name + ": " + msg);
    }
}

// Publisher (Yayıncı)
public class NotificationSystem {
    private List<Subscriber> users = new ArrayList<>();
    
    public void subscribe(Subscriber user) { users.add(user); }
    
    public void sendAll(String msg) {
        for (Subscriber u : users) {
            u.notifyUser(msg);  // Tüm abonelere bildirim
        }
    }
}

// Kullanım
NotificationSystem notif = new NotificationSystem();
notif.subscribe(new Customer("Ali"));
notif.subscribe(new Customer("Ayşe"));
notif.sendAll("Aracınız hazır!");
// Çıktı:
// SMS to Ali: Aracınız hazır!
// SMS to Ayşe: Aracınız hazır!
```

**Bileşenler:**

| Rol | Sınıf | Görev |
|-----|-------|-------|
| Publisher | NotificationSystem | Abone listesini yönetir, herkese bildirim gönderir |
| Subscriber | Subscriber (interface) | Bildirim alma sözleşmesi |
| Concrete Subscriber | Customer | SMS ile bildirim alır |

---

### 6. 🏛️ Facade Pattern (Cephe Deseni)
**Dosya:** `structural/RentalService.java`

**Amaç:** Karmaşık alt sistemleri tek bir basit arayüz arkasında gizler.

**Kullanım Senaryosu:** Kiralama işleminin tüm adımlarını (strateji seçimi, fiyat hesaplama, bildirim) tek metodda toplar.

**Çözülen Problem:**
- Kiralama yapmak için birçok farklı sistemi sırayla çağırmak gerekir
- İstemci kodu tüm alt sistemleri bilmek zorunda kalır

**Nasıl Çalışır:**
```java
public class RentalService {
    public void processRental(String customerName, Rentable car, int days, String customerType) {
        // 1. Strategy Pattern - Fiyat stratejisi seç
        PricingPolicy policy = selectPolicy(customerType);
        
        // 2. Fiyat hesapla
        double dailyCost = policy.calculate(car.getCost());
        double totalCost = dailyCost * days;
        
        // 3. Fatura yazdır
        printInvoice(car, days, totalCost);
        
        // 4. Observer Pattern - Müşteriye bildirim gönder
        NotificationSystem notif = new NotificationSystem();
        notif.subscribe(new Customer(customerName));
        notif.sendAll("Aracınız hazır!");
    }
}

// Kullanım - TEK SATIR ile tüm işlemler
service.processRental("Ali Baba", car, 7, "HOLIDAY");
```

**Facade'ın Sardığı Alt Sistemler:**
1. **Strategy Pattern:** Fiyatlandırma stratejisi seçimi
2. **Observer Pattern:** Müşteri bildirim sistemi
3. **Temel Hesaplamalar:** Maliyet hesabı

---

## ▶️ Programı Çalıştırma

### Gereksinimler
- Java JDK 8 veya üzeri
- IntelliJ IDEA (önerilen) veya başka bir Java IDE

### Çalıştırma Adımları

1. **Projeyi IntelliJ IDEA ile açın:**
   ```
   File → Open → DesignPatternsProject klasörünü seçin
   ```

2. **Main.java dosyasını çalıştırın:**
   ```
   src/Main.java → Sağ tık → Run 'Main.main()'
   ```

3. **Veya komut satırından:**
   ```bash
   cd src
   javac Main.java core/*.java creational/*.java structural/*.java behavioral/*.java
   java Main
   ```

### Beklenen Çıktı

```
=== PROFESSIONAL CAR RENTAL SYSTEM (6 PATTERNS) ===

[Singleton] Yapılandırması Başlatıldı.
[Singleton] Veritabanına Bağlandı (PostgreSQL)..

--- [Facade] Rental Process Starting for: Ali Baba ---
[Strategy] Holiday Seasonal Discount applied (-20%)
core.Vehicle: [Van] Volkswagen Transporter (Family Size) + Baby Seat + Winter Tires
Days: 7
Total Cost: 7728.0 TL
[Observer] SMS to Ali Baba: Your car is ready at the gate. Enjoy your ride!
--- [Facade] Process Completed ---

--- [Facade] Rental Process Starting for: Elon Musk ---
[Strategy] VIP Corporate Discount applied (-30%)
core.Vehicle: [EV] Tesla Model S (Eco-Friendly) + Chauffeur + GPS
Days: 2
Total Cost: 4270.0 TL
[Observer] SMS to Elon Musk: Your car is ready at the gate. Enjoy your ride!
--- [Facade] Process Completed ---

--- [Facade] Rental Process Starting for: Genç Çift ---
[Strategy] Standard pricing applied (no discount)
core.Vehicle: [Sports] Ferrari 488 Spider (High Performance) + Sunroof
Days: 3
Total Cost: 15450.0 TL
[Observer] SMS to Genç Çift: Your car is ready at the gate. Enjoy your ride!
--- [Facade] Process Completed ---

=== SYSTEM SHUTDOWN ===
```

---

## 🔄 Sistem Akış Diyagramı

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                          ARAÇ KİRALAMA SİSTEMİ                              │
└─────────────────────────────────────────────────────────────────────────────┘

1. HAZIRLIK
   ┌──────────────────┐     ┌──────────────────┐
   │  SystemConfig    │     │    FleetHub      │
   │   (Singleton)    │     │   (Factory)      │
   │                  │     │                  │
   │ • DB bağlantısı  │     │ • Araç üretimi   │
   │ • Tek instance   │     │ • Tip → Nesne    │
   └──────────────────┘     └──────────────────┘
           │                        │
           ▼                        ▼
2. KİŞİSELLEŞTİRME
   ┌──────────────────────────────────────────┐
   │            CarDecorator                   │
   │             (Decorator)                   │
   │                                           │
   │  Minivan → WithChildSeat → WithGPS       │
   │  1200 TL → +100 TL → +50 TL = 1350 TL    │
   └──────────────────────────────────────────┘
                    │
                    ▼
3. FİYATLANDIRMA
   ┌──────────────────────────────────────────┐
   │          PricingPolicy                    │
   │           (Strategy)                      │
   │                                           │
   │  VIP → %30 indirim                        │
   │  Holiday → %20 indirim                    │
   │  Normal → İndirim yok                     │
   └──────────────────────────────────────────┘
                    │
                    ▼
4. İŞLEM
   ┌──────────────────────────────────────────┐
   │          RentalService                    │
   │            (Facade)                       │
   │                                           │
   │  processRental() → Tek method ile:       │
   │  • Strateji seçimi                        │
   │  • Fiyat hesaplama                        │
   │  • Fatura oluşturma                       │
   │  • Bildirim gönderme                      │
   └──────────────────────────────────────────┘
                    │
                    ▼
5. BİLDİRİM
   ┌──────────────────────────────────────────┐
   │       NotificationSystem                  │
   │          (Observer)                       │
   │                                           │
   │  Publisher ──► Subscriber                │
   │  (Sistem)      (Müşteri)                 │
   │                                           │
   │  "Aracınız hazır!" → SMS gönder          │
   └──────────────────────────────────────────┘
```

---

## 📚 Demo Senaryoları

Program çalıştırıldığında 3 farklı kiralama senaryosu gösterilir:

### Senaryo 1: Aile Tatili
| Özellik | Değer |
|---------|-------|
| Müşteri | Ali Baba |
| Araç Tipi | FAMILY (Minivan) |
| Araç | Volkswagen Transporter |
| Eklentiler | Çocuk Koltuğu (+100 TL), Kış Lastiği (+80 TL) |
| Süre | 7 gün |
| İndirim | Tatil İndirimi (%20) |
| **Hesaplama** | (1200 + 100 + 80) × 7 × 0.8 = **7.728 TL** |

### Senaryo 2: VIP İş Adamı
| Özellik | Değer |
|---------|-------|
| Müşteri | Elon Musk |
| Araç Tipi | ELECTRIC |
| Araç | Tesla Model S |
| Eklentiler | Şoför (+500 TL), GPS (+50 TL) |
| Süre | 2 gün |
| İndirim | VIP İndirim (%30) |
| **Hesaplama** | (2500 + 500 + 50) × 2 × 0.7 = **4.270 TL** |

### Senaryo 3: Genç Çift
| Özellik | Değer |
|---------|-------|
| Müşteri | Genç Çift |
| Araç Tipi | SPORT |
| Araç | Ferrari 488 Spider |
| Eklentiler | Açılır Tavan (+150 TL) |
| Süre | 3 gün |
| İndirim | Normal Fiyat (yok) |
| **Hesaplama** | (5000 + 150) × 3 × 1.0 = **15.450 TL** |

---

## 🧩 SOLID Prensipleri Uygulaması

| Prensip | Açıklama | Projede Uygulama |
|---------|----------|------------------|
| **S** - Single Responsibility | Her sınıf tek bir sorumluluğa sahip olmalı | Her dekoratör sadece kendi eklentisinden sorumlu |
| **O** - Open/Closed | Genişletmeye açık, değişikliğe kapalı | Yeni araç tipi veya indirim eklemek için mevcut kod değişmez |
| **L** - Liskov Substitution | Alt sınıflar üst sınıf yerine kullanılabilmeli | Rentable arayüzü sayesinde tüm araçlar ve dekoratörler birbirinin yerine geçebilir |
| **I** - Interface Segregation | Arayüzler küçük ve özelleşmiş olmalı | Rentable, Subscriber, PricingPolicy gibi ayrı arayüzler |
| **D** - Dependency Inversion | Soyutlamalara bağımlı olunmalı | RentalService, somut sınıflar yerine PricingPolicy arayüzüne bağımlı |

---

## 📝 Sonuç

Bu proje, yazılım tasarım desenlerinin gerçek dünya problemlerini nasıl çözdüğünü göstermektedir:

1. **Singleton:** Kaynak yönetimi ve merkezi konfigürasyon
2. **Factory:** Nesne oluşturma karmaşıklığını gizleme
3. **Decorator:** Dinamik özellik ekleme, kalıtım yerine kompozisyon
4. **Strategy:** Algoritma değiştirilebilirliği, if-else'den kurtulma
5. **Observer:** Gevşek bağlı bildirim sistemi
6. **Facade:** Karmaşık sistemleri basitleştirme

Tüm bu desenler birlikte çalışarak **modüler**, **genişletilebilir** ve **bakımı kolay** bir sistem oluşturur.

---

## 👨‍💻 Yazar

**Emre**

---

*Bu proje, yazılım tasarım desenleri eğitimi amacıyla geliştirilmiştir.*
