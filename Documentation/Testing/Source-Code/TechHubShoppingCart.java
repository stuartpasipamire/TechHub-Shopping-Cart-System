package techhub;

import java.util.ArrayList;
import java.util.Scanner;

public class TechHubShoppingCart {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Product> catalogue = new ArrayList<>();
        catalogue.add(new Product(1, "Laptop", 599.99, "15-inch laptop"));
        catalogue.add(new Product(2, "Wireless Mouse", 24.99, "Bluetooth mouse"));
        catalogue.add(new Product(3, "Mechanical Keyboard", 89.99, "RGB keyboard"));
        catalogue.add(new Product(4, "USB-C Hub", 34.99, "Multi-port adapter"));
        catalogue.add(new Product(5, "Laptop Stand", 29.99, "Adjustable stand"));
        catalogue.add(new Product(6, "Wireless Headphones", 149.99, "Noise cancelling"));
        catalogue.add(new Product(7, "HD Camera", 54.99, "1080p webcam"));
        catalogue.add(new Product(8, "External SSD", 89.99, "Fast portable storage"));

        ShoppingCart cart = new ShoppingCart();
        boolean running = true;

        while (running) {
            System.out.println("\n=== TechHub Solutions Ltd ===");
            System.out.println("1. Browse Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt(input);

            switch (choice) {
                case 1:
                    showProducts(catalogue);
                    break;

                case 2:
                    showProducts(catalogue);
                    System.out.print("Enter product number: ");
                    int id = readInt(input);

                    Product selected = findProduct(catalogue, id);

                    if (selected != null) {
                        cart.addProduct(selected);
                        System.out.println("Added to cart: " + selected.getName());
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:
                    checkout(cart, input);
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-5.");
                    break;
            }
        }

        input.close();
    }

    private static void showProducts(ArrayList<Product> catalogue) {
        System.out.println("\n--- PRODUCT LIST ---");
        for (Product p : catalogue) {
            System.out.println(
                p.getId() + ". " + p.getName()
                + " - GBP " + String.format("%.2f", p.getPrice())
                + " (" + p.getDescription() + ")"
            );
        }
    }

    private static Product findProduct(ArrayList<Product> catalogue, int id) {
        for (Product p : catalogue) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private static void checkout(ShoppingCart cart, Scanner input) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        cart.displayCart();
        System.out.print("Confirm purchase (Y/N): ");
        String answer = input.next().trim().toUpperCase();

        if (answer.equals("Y") || answer.equals("YES")) {
            System.out.println("Thank you for shopping with TechHub!");
            cart.clear();
        } else {
            System.out.println("Checkout cancelled.");
        }
    }

    private static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a number: ");
            input.next();
        }
        return input.nextInt();
    }
}