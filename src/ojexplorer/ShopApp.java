//package ojexplorer;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
////import io.helidon.webserver.Routing;
//import io.helidon.webserver.Routing;
//import io.helidon.webserver.ServerConfiguration;
//import io.helidon.webserver.WebServer;
//
//public class ShopApp {
//
//    public static void main(String[] args) {
//        Customer customer = new Customer("Pinky", "S");
//        int measurement = 3;
//        switch (measurement) {
//            case 1: case 2: case 3:
//                customer.setSize("S");
//            break;
//            case 4: case 5: case 6:
//                customer.setSize("M");
//            break;
//            case 7: case 8: case 9:
//                customer.setSize("L");
//            break;
//            default:
//                customer.setSize("X");
//            break;
//        }
//
//        Clothing item1 = new Clothing();
//        Clothing item2 = new Clothing();
//        item1.setDescription("Blue Jacket");
//        item1.setPrice(20.5);
//        item1.setSize("S");
//        item2.setDescription("Orange Jacket");
//        item2.setPrice(10.5);
//        item2.setSize("M");
//
//        Clothing[] items = {item1, item2,
//                new Clothing("Green Scarf", 5.5, "M"),
//                new Clothing("Blue Shirt", 18.5, "S")};
//
//        double total = 0.0;
//        for (Clothing cloth : items) {
//            total += cloth.getPrice();
//            System.out.println("Item" + "," + cloth.getDescription() +
//                    ", price" + cloth.getPrice() + ", size" + cloth.getSize());
//        }
//        System.out.println("Total =" + total);
//
//        customer.addItem(items);
//        Arrays.sort(customer.getClothingList());
//
//        for (Clothing cloth : items) {
//            total += cloth.getPrice();
//            System.out.println("Item" + "," + cloth.getDescription() +
//                    ", price" + cloth.getPrice() + ", size" + cloth.getSize());
//        }
//
//        ItemList list = new ItemList(items);
//        Routing routing = Routing.builder().get("/items", list).build();
//
//        try {
//            ServerConfiguration serverConfiguration = ServerConfiguration
//                    .builder().bindAddress(InetAddress.getLocalHost())
//                    .port(8888).build();
//            WebServer ws = WebServer.create(serverConfiguration, routing);
//            ws.start();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//    }
//}
