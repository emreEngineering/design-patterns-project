package behavioral;

class Customer implements Subscriber {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void notifyUser(String msg) {
        System.out.println("[Observer] SMS to " + name + ": " + msg);
    }
}
