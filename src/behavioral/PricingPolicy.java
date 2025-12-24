package behavioral;

// [4] STRATEGY: PricingPolicy
// Fiyat hesaplama algoritmasını dinamik olarak değiştirir.
interface PricingPolicy {
    double calculate(double price);
}
