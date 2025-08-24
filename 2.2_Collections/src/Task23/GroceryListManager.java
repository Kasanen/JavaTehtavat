package Task23;

import java.util.ArrayList;

class Item {

    String item;
    double cost;
    String category;
    int quantity;

    public Item(String item, double cost, String category, int quantity) {
        this.item = item;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return item + " (" + category + ") = " + cost + " x " + quantity;
    }
}

public class GroceryListManager {

    private ArrayList<Item> groceryList = new ArrayList<>();

    public void addItem(String item, double cost, String category, int quantity) {
        for (Item existingItem : groceryList) {
            if (existingItem.item.equals(item)) {
                System.err.println("Item already in the list.");
                return;
            }
        }
        groceryList.add(new Item(item, cost, category, quantity));
    }

    public void removeItem(String item) {
        System.out.println("Removing " + item + " from the list...\n");
        // Helpoin ja kätevin ratkaisu by AI
        groceryList.removeIf(i -> i.item.equals(item));
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (Item item : groceryList) {
            System.out.println(item);
        }
        System.out.println("\n");
    }

    public void checkItem(String item) {
        System.out.println("Is " + item + " in the grocery list? " + groceryList.contains(item) + "\n");
    }

    public void calculateTotalCost() {
        double total = 0;
        for (Item existingItem : groceryList) {
            total += existingItem.cost;
        }
        System.out.println("Total cost: " + total);
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (Item existingItem : groceryList) {
            if (existingItem.category.equals(category)) {
                System.out.println(existingItem.item);
            }
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        for (Item existingItem : groceryList) {
            if (existingItem.item.equals(item)) {
                existingItem.quantity = newQuantity;
                System.out.println("Updated " + item + " quantity to " + newQuantity);
                return;
            }
        }
        System.out.println("Item not found in the list.");
    }

    public void displayAvailableItems(){
        for (Item existingItem : groceryList){
            if (existingItem.quantity > 0){
                System.out.println(existingItem);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 2.99, "Fruits", 5);
        manager.addItem("Milk", 5.00, "Dairy", 1);
        manager.addItem("Bread", 1.29, "Bakery", 0);

        manager.addItem("Milk", 3.00, "Dairy", 50);

        manager.displayList();
        manager.displayByCategory("Dairy");

        manager.checkItem("Milk");
        manager.removeItem("Milk");
        manager.displayList();
        manager.calculateTotalCost();

        manager.updateQuantity("Apples", 3);
        manager.displayAvailableItems();
    }
}
