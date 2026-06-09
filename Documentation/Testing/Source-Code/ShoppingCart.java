package techhub;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n--- YOUR CART ---");
        double total = 0.0;

        for (Product p : items) {
            System.out.println(p.getName() + " - GBP " + String.format("%.2f", p.getPrice()));
            total += p.getPrice();
        }

        System.out.println("-----------------");
        System.out.println("TOTAL: GBP " + String.format("%.2f", total));
    }
}
