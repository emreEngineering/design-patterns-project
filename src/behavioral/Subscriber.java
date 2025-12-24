package behavioral;

// [5] OBSERVER: NotificationSystem
// Müşterilere otomatik bildirim (SMS/Mail) gönderir.
interface Subscriber {
    void notifyUser(String msg);
}
