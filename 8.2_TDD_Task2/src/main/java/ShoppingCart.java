
import java.util.ArrayList;

public class ShoppingCart {
    public static class CartItem {

        private String item;
        private double cost;

        public CartItem(String item, double cost) {
            this.item = item;
            this.cost = cost;
        }

        public String getItem() {
            return item;
        }

        public double getCost() {
            return cost;
        }
    }

    private ArrayList<CartItem> cart = new ArrayList<>();

    public void addItem(String item, double quantity) {
        cart.add(new CartItem(item, quantity));
    }

    public void removeItem(String itemR){
        int index = 0;
        for(CartItem item : cart){
            if (item.getItem().equals(itemR)){
                cart.remove(index);
            }
            index ++;
        }
    }

    public int getItemCount(){
        return cart.size();
    }

    public double calculateTotal(){
        double total = 0;
        for(CartItem cost : cart){
            total += cost.getCost();
        }
        return total;
    }
}
