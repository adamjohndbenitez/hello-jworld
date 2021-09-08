package linkedin.advancejava;

public class CustomerStore {
    private boolean hasBeenServed;
    private String name;

    public CustomerStore(boolean hasBeenServed, String name) {
        this.hasBeenServed = hasBeenServed;
        this.name = name;
    }

    public CustomerStore(String name) {
        this.name = name;
    }

    public void serve() {
        hasBeenServed = false;
        System.out.println(name + " has been served.");
    }

    @Override
    public String toString() {
        return name;
    }
}
