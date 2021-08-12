package ojexplorer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
        String name;
        String size;

        public Customer(String name, String size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        Clothing[] clothingList;

        public void addItem(Clothing[] clothings) {
            clothingList = clothings;
        }

        public Clothing[] getClothingList() {
            return clothingList;
        }
}
