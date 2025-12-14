package behavioral;

class StandardRate implements PricingPolicy {
    public double calculate(double rawPrice) {
        return rawPrice;
    }
}
