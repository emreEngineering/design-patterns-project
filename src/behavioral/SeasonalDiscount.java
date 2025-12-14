package behavioral;

public class SeasonalDiscount implements PricingPolicy {
    public double calculate(double rawPrice) {
        System.out.println("[Pricing] Mevsimlik İndirim Uygulandı (-20%)");
        return rawPrice * 0.8;
    }
}
