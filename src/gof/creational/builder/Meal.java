package gof.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : itemList) {
            cost += item.price();
        }

        return cost;
    }

    public void showItems() {
        for (Item item : itemList) {
            System.out.println("Item : " + item.name());
            System.out.println(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
