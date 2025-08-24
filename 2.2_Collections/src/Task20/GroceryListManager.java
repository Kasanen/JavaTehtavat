package Task20;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {

    HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        if (groceryList.containsKey(item)) {
            System.err.println("Item already in the list.");
            return;
        }
        groceryList.put(item, cost);
    }

    public void removeItem(String item) {
        System.out.println("Removing " + item + " from the list...\n");
        groceryList.remove(item);
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (Map.Entry<String, Double> item : groceryList.entrySet()) {
            System.out.println(item);
        }
        System.out.println("\n");
    }

    public void checkItem(String item) {
        System.out.println("Is " + item + " in the grocery list? " + groceryList.containsKey(item) + "\n");
        // skippaa for loopin ja ifit
    }

    public void calculateTotalCost() {
        double total = 0;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            total += entry.getValue();
        }
        System.out.println("Total cost: " + total);
    }

    public static void main(String[] args) throws Exception {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 2.99);
        manager.addItem("Milk", 5.00);
        manager.addItem("Bread", 1.29);

        manager.addItem("Milk", 3.00);

        manager.displayList();

        manager.checkItem("Milk");
        manager.removeItem("Milk");
        manager.displayList();
        manager.calculateTotalCost();
    }
}
