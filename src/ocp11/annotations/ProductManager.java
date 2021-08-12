package ocp11.annotations;

import java.util.Arrays;
import java.util.List;

public class ProductManager {
    /**
     * @deprecated This method has been deprecated,
     * as it is inherently deadlock-prone.
     * Please use {@link #commit} method instead
     */
//    @Deprecated(since = "11", forRemoval = true) // Error: cannot resolve method 'since & 'forRemove'
    @Deprecated
    public synchronized void save() {

    }

    public void commit() {

    }

    public List find() {
        return Arrays.asList(new Food("Cake", 2.99), new Drink("Tea", 1.99));
    }
}

class Food {
    private String name;
    private double price;
    Food(String name, double price){
        this.name = name;
        this.price = price;
    }
}
class Drink {
    private String name;
    private double price;
    Drink(String name, double price){
        this.name = name;
        this.price = price;
    }
}
