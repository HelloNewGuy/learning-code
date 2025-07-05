import java.util.Scanner;

public class StatsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        float total = 0;
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;

        System.out.println("Enter 5 floating-point numbers:");

        while (count < 5) {
            System.out.print("Enter number " + (count + 1) + ": ");

            if (scanner.hasNextFloat()) {
                float number = scanner.nextFloat();
                total += number;

                if (number > max) max = number;
                if (number < min) min = number;

                count++;
            } else {
                System.out.println("Invalid input. PLease enter a valid floating-point number.");
                scanner.next();
            }
        }

        float average = total / 5;
        float interest = total * 0.20f;

        System.out.println("\n----- Results -----");
        System.out.printf("Total: %.2f\n" , total);
        System.out.printf("Average: %.2f\n" , average);
        System.out.printf("Maximum: %.2f\n" , max);
        System.out.printf("Minimum: %.2f\n" , min);
        System.out.printf("Interest on total at 20%%: %.2f\n" , interest);

        scanner.close();
    }
}
