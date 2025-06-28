//The import scanner class will be used to read user's input
import java.util.Scanner;

public class TaxCalculator {

    public static void main(String[] args) {
        //Create input reader
        Scanner scanner = new Scanner(System.in);
        //Prompt user to enter income
        System.out.print("Enter your weekly income: $");
        //use double to get income and store as a decimal number
        double income = scanner.nextDouble();
        double taxRate;
        //Decision-making structure
        if (income <500) {
            taxRate = 0.10;
        } else if (income < 1500) {
            taxRate = 0.15;
        } else if (income < 2500) {
            taxRate = 0.20;
        } else {
            taxRate = 0.30;
        }
        //Calculate tax amount
        double taxWithholding = income * taxRate;
        //show the result of calculation and display tax formated to 2 decimal places
        System.out.printf("Weekly Tax withholding: $%.2f%n" , taxWithholding);

        scanner.close();
    }
}
