package behavioral;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter {
    private List<Subscriber> users = new ArrayList<>();

    public void subscribe(Subscriber user) {
        users.add(user);
    }

    public void blast(String message) {
        System.out.println("[behavioral.NotificationCenter] Toplu mesaj gönderiyorum...");
        for (Subscriber user : users) {
            user.update(message);
        }
    }
}
