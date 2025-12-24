package behavioral;

import java.util.ArrayList;
import java.util.List;

class NotificationSystem {
    private List<Subscriber> users = new ArrayList<>();

    public void subscribe(Subscriber user) {
        users.add(user);
    }

    public void sendAll(String msg) {
        for (Subscriber u : users) u.notifyUser(msg);
    }
}
