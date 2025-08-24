package Task19;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if(groceryList.contains(item)){
            System.err.println("Item already in the list.");
            return;
        }
        groceryList.add(item);
    }

    public void removeItem(String item) {
        System.out.println("Removing " + item + " from the list...\n");
        groceryList.remove(item);
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (String item : groceryList) {
            System.out.println(item);
        }
        System.out.println("\n");
    }

    public void checkItem(String item) {
        System.out.println("Is " + item + " in the grocery list? " + groceryList.contains(item)+"\n");
        // skippaa for loopin ja ifit
    }

    public static void main(String[] args) throws Exception {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        manager.addItem("Milk");

        manager.displayList();

        manager.checkItem("Milk");
        manager.removeItem("Milk");
        manager.displayList();
    }
}
