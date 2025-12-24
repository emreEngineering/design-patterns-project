package behavioral;

class NormalPrice implements PricingPolicy {
    public double calculate(double price) {
        return price;
    }
}
