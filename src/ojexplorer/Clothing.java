package ojexplorer;

public class Clothing implements Comparable<Clothing> {
    String description;
    double price;
    String size;

    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }

    public Clothing() {

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    @Override
    public int compareTo(Clothing o) {
        return this.description.compareTo(o.getDescription());
    }
}
