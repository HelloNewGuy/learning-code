package src;
import java.util.Scanner;

public class PassWithWhile {

    private static final String CORRECT_PASSWORD = "LearningJava!";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String password;

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        while (!password.equals(CORRECT_PASSWORD)) {
            System.out.println("Incorrect password. Try again.");

            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }
        System.out.print("Access Granted!");
        scanner.close();
    }
}
