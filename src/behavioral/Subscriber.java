package behavioral;

// [7] OBSERVER -> behavioral.NotificationCenter
// Müşterilere kampanya/stok haberi verir.
interface Subscriber {
    void update(String news);
}
