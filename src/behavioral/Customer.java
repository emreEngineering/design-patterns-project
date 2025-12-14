package behavioral;

public class Customer implements Subscriber {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println("[Notification] Merhaba " + name + ", " + news);
    }
}
