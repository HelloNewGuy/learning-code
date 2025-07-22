import java.util.Scanner;

abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }
}

class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = null;

        System.out.println("Choose a shape to calculate the area:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Square");
        System.out.println("4. Triangle");
        System.out.println("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the radius: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case 2:
                System.out.print("Enter the width: ");
                double width = scanner.nextDouble();
                System.out.print("Enter the height: ");
                double height = scanner.nextDouble();
                shape = new Rectangle(width, height);
                break;
            case 3:
                System.out.print("Enter the side length: ");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            case 4:
                System.out.print("Enter the base: ");
                double triBase = scanner.nextDouble();
                System.out.print("Enter the height: ");
                double triHeight = scanner.nextDouble();
                shape = new Triangle(triBase, triHeight);
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        System.out.printf("The area is: %.2f%n", shape.calculateArea());
        scanner.close();
    }
}
