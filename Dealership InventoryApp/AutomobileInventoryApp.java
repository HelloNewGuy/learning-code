import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AutomobileInventoryApp {
    private static ArrayList<Automobile> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            boolean running = true;
            while (running) {
                System.out.println("\n--- Automobile Inventory Menu ---");
                System.out.println("1. Add Vehicle");
                System.out.println("2. List All Vehicles");
                System.out.println("3. Remove Vehicle");
                System.out.println("4. Update Vehicle");
                System.out.println("5. Save to File");
                System.out.println("6. Exit");
                System.out.print("Choose an Option: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        addVehicle();
                        break;
                    case "2":
                        listVehicles();
                        break;
                    case "3":
                        removeVehicle();
                        break;
                    case "4":
                        updateVehicle();
                        break;
                    case "5":
                        saveToFile();
                        break;
                    case "6":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in program: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String promptNonEmpty(String prompt) {
        String input = "";
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private static int promptPositiveInt(String prompt, String fieldName) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());

                if (value <= 0) {
                    System.out.println("Value must be greater than 0.");
                    continue;
                }

                if (fieldName.equalsIgnoreCase("year")) {
                    int currentYear = java.time.Year.now().getValue();
                    if (value < 1886 || value > currentYear) {
                        System.out.println("Year must be between 1886 and " + currentYear + ".");
                        continue;
                    }
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
    }

    private static void addVehicle() {
        try {
            String make = promptNonEmpty("Enter make: ");
            String model = promptNonEmpty("Enter model: ");
            String color = promptNonEmpty("Enter color: ");
            int year = promptPositiveInt("Enter year: ", "year");
            int mileage = promptPositiveInt("Enter mileage: ", "mileage");

            Automobile car = new Automobile(make, model, color, year, mileage);
            inventory.add(car);
            System.out.println("Vehicle added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add vehicle: " + e.getMessage());
        }
    }

    private static void listVehicles() {
        try {
            if (inventory.isEmpty()) {
                System.out.println("No vehicles in inventory.");
                return;
            }
            System.out.println("\n--- Vehicle List ---");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i).getInfo());
            }
        } catch (Exception e) {
            System.out.println("failed to list vehicles: " + e.getMessage());
        }
    }

    private static void removeVehicle() {
        try {
            listVehicles();
            System.out.print("Enter the number of the vehicle to remove: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < inventory.size()) {
                inventory.remove(index);
                System.out.println("Vehicle removed successfully!");
            } else {
                System.out.println("Invalid vehicle number.");
            }
        } catch (Exception e) {
            System.out.println("Failed to remove vehicle: " + e.getMessage());
        }
    }

    private static void updateVehicle() {
        try {
            listVehicles();
            System.out.print("Enter the number of the vehicle to update: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < inventory.size()) {
                System.out.print("Enter new make: ");
                String make = scanner.nextLine();
                System.out.print("Enter new model: ");
                String model = scanner.nextLine();
                System.out.print("Enter new color: ");
                String color = scanner.nextLine();
                System.out.print("Enter new year: ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new mileage: ");
                int mileage = Integer.parseInt(scanner.nextLine());

                inventory.get(index).update(make, model, color, year, mileage);
                System.out.println("Vehicle updated successfully!");
            } else {
                System.out.println("Invalid vehicle number.");
            }
        } catch (Exception e) {
            System.out.println("Failed to update vehicle: " + e.getMessage());
        }
    }

    private static void saveToFile() {
        try {
            if (inventory.isEmpty()) {
                System.out.println("No vehicles to save.");
                return;
            }

            java.io.File dir = new java.io.File("C://Temp");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            PrintWriter writer = new PrintWriter(new FileWriter("C://Temp/Autos.txt"));
            for (Automobile car : inventory) {
                writer.println(car.getInfo());
            }
            writer.close();
            System.out.println("Vehicle information saved to C://Temp/Autos.txt");
        } catch (Exception e) {
            System.out.println("Failed to write to file: " + e.getMessage());
        }
    }

}