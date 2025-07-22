package src;
import java.util.Scanner;

public class StoreInventory {

    public static void main (String[] args) {
        String[] products = {"Apples" , "Bananas" , "Oranges" , "Grapes"};
        int[] quantities = {50 , 30 , 45 , 20};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Inventory");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + ": " + quantities[i] + " in stock");
        }

        System.out.println("\nEnter the product name to update its quantity: ");
        String inputproduct = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < products.length; i++) {
            if (products[i].equalsIgnoreCase(inputproduct)) {
                System.out.print("Enter new quatity for " + products[i] + ": ");
                quantities[i] = scanner.nextInt();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found in inventory.");
        }

        System.out.println("\nUpdated Inventory: ");
        for (int i = 0; i < products.length; i++) {
                System.out.println(products[i] + ": " + quantities[i] + " in stock");
        }

        scanner.close();
    }
}

