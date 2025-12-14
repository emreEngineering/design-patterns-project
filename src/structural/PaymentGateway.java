package structural;

// Adaptör
class PaymentGateway implements PaymentInterface {
    private LegacyBankApi bankApi;

    public PaymentGateway() {
        this.bankApi = new LegacyBankApi();
    }

    @Override
    public void process(double amount) {
        System.out.println("[PaymentGateway] Dış bankaya bağlanıyor...");
        bankApi.transferFunds(amount);
    }
}
