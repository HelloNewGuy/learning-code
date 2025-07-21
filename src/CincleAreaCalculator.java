package src;
import java.util.Scanner;

public class CincleAreaCalculator {

    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Circle Area Calculator");

        System.out.print("Enter the number of circles: ");
        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter the radius for circle " + i + ": ");
            double radius = scanner.nextDouble();

            double area = calculateArea(radius);

            System.out.printf("The area of circle %d is: %.2f\n" , i , area);
        }

        scanner.close();
    }
}
