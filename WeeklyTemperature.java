package src;
import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        ArrayList<String> descriptions = new ArrayList<>();

        String[] weekDays = {"Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday" , "Saturday" , "Sunday"};

        System.out.println(" Enter the average temperature (°F) and a weather description (Sunny, Rainy, Cloudy) for each day of the week.\n");

        for (String day : weekDays) {
            System.out.print("Enter temperature for " + day + " (°F): ");
            double temp = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter weather description for " + day + "(Sunny, Rainy, Cloudy): ");
            String desc = scanner.nextLine();

            days.add(day);
            temperatures.add(temp);
            descriptions.add(desc);
            System.out.println();
        }

        System.out.println("All temperatures recorded!");

        System.out.println("\nWhat day would you like to view?");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("week")) {
            double sum = 0;

            System.out.println("\nWeekly Temperature Report:");
            System.out.printf("%-10s %-10s %-12s %s%n" , "Day" , "Temp (°F)" , "Weather" , "Clothing Suggestion");
            System.out.println("---------------------------------------------------------------");

            for (int i = 0; i < days.size(); i++) {
                String day = days.get(i);
                double temp = temperatures.get(i);
                String desc = descriptions.get(i);
                String clothing = suggestClothing(temp);

                System.out.printf("%-10s %-10.1f %-12s %s%n", day, temp, desc, clothing);
                sum +=temp;
            }

            double average = sum / temperatures.size();
            System.out.printf("\nWeekly Average Temperature: %.2f°F%n", average);
        } else {
            boolean found = false;

            for (int i = 0; i < days.size(); i++) {
                if (days.get(i).equalsIgnoreCase(input)) {
                    String clothing = suggestClothing(temperatures.get(i));
                    System.out.println("\nDaily Weather Report: ");
                    System.out.printf("%-10s: %.1f°F, %-10s - %s%n", days.get(i), temperatures.get(i), descriptions.get(i), clothing);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid input. Please enter a valid day of the week or 'week'.");
            }
        }

        scanner.close();
    }
    public static String suggestClothing(double tempF) {
        if (tempF >= 90) {
            return "Very hot - wear light clothing and stay hydrated";
        } else if (tempF >= 75) {
            return "Warm - T-shirt and shorts recommended";
        } else if (tempF >= 60) {
            return "Mild - Light jacket or long sleeves suggested";
        } else if (tempF >= 45) {
            return "Cool - jacket and warm clothes recommended";
        } else if (tempF >= 32) {
            return "Cold - wear a coat and layers";
        } else {
            return "Freezing - Heavy winter gear if necessary";
        }
    }
}
