package behavioral;

// [8] STRATEGY -> behavioral.PricingPolicy
// Fiyat hesaplama algoritmasını değiştirilebilir yapar.
public interface PricingPolicy {
    double calculate(double rawPrice);
}
