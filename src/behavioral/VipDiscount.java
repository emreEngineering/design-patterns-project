package behavioral;

class VipDiscount implements PricingPolicy {
    public double calculate(double price) {
        System.out.println("[Strategy] VIP Corporate Discount applied (-30%)");
        return price * 0.7;
    }
}
