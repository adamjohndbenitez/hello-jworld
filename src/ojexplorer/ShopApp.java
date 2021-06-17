package ojexplorer;

public class ShopApp {

    public static void main(String[] args) {
        Customer customer = new Customer("Pinky", "S");
        int measurement = 3;
        switch (measurement) {
            case 1: case 2: case 3:
                customer.setSize("S");
            break;
            case 4: case 5: case 6:
                customer.setSize("M");
            break;
            case 7: case 8: case 9:
                customer.setSize("L");
            break;
            default:
                customer.setSize("X");
            break;
        }

        Clothing item1 = new Clothing();
        Clothing item2 = new Clothing();
        item1.setDescription("Blue Jacket");
        item1.setPrice(20.5);
        item1.setSize("S");
        item2.setDescription("Orange Jacket");
        item2.setPrice(10.5);
        item2.setSize("M");

        Clothing[] items = {item1, item2};

        double total = 0.0;
        for (Clothing cloth : items) {
            total += cloth.getPrice();
            System.out.println("Item" + "," + cloth.getDescription() +
                    ", price" + cloth.getPrice() + ", size" + cloth.getSize());
        }
        System.out.println("Total =" + total);
    }
}
