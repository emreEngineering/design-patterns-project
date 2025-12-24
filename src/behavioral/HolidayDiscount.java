package behavioral;

class HolidayDiscount implements PricingPolicy {
    public double calculate(double price) {
        System.out.println("[Strategy] Holiday Discount applied (-20%)");
        return price * 0.8;
    }
}
