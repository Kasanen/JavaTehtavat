package Task21;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {

    static class GroceryType {

        private double cost;
        private String category;

        public GroceryType(double cost, String category) {
            this.cost = cost;
            this.category = category;
        }

        public double getCost() {
            return cost;
        }

        public String getCategory() {
            return category;
        }

        // Formatoi tekstin parempaan muotoon
        // $% integer ja %s string
        @Override
        public String toString() {
            return String.format("$%.2f (%s)", cost, category);
        }
    }

    HashMap<String, GroceryType> groceryList = new HashMap<>();

    public void addItem(String item, double cost, String category) {
        if (groceryList.containsKey(item)) {
            System.err.println("Item already in the list.");
            return;
        }
        groceryList.put(item, new GroceryType(cost, category));
    }

    public void removeItem(String item) {
        System.out.println("Removing " + item + " from the list...\n");
        groceryList.remove(item);
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (Map.Entry<String, GroceryType> item : groceryList.entrySet()) {
            System.out.println(item);
        }
        System.out.println("\n");
    }

    public void checkItem(String item) {
        System.out.println("Is " + item + " in the grocery list? " + groceryList.containsKey(item) + "\n");
    }

    public void calculateTotalCost() {
        double total = 0;
        for (Map.Entry<String, GroceryType> entry : groceryList.entrySet()) {
            total += entry.getValue().getCost();
        }
        System.out.println("Total cost: " + total);
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (Map.Entry<String, GroceryType> entry : groceryList.entrySet()) {
            if (category == entry.getValue().getCategory()){
                System.out.println(entry);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 2.99, "Fruits");
        manager.addItem("Milk", 5.00, "Dairy");
        manager.addItem("Bread", 1.29, "Bakery");

        manager.addItem("Milk", 3.00, "Dairy");

        manager.displayList();
        manager.displayByCategory("Dairy");

        manager.checkItem("Milk");
        manager.removeItem("Milk");
        manager.displayList();
        manager.calculateTotalCost();

    }
}
