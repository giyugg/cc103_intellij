package activities;
import java.util.Scanner;

public class CalculatorMethod {

    static Scanner input = new Scanner(System.in);
    static double num1, num2;
    static char choice;
    static char again;

    public static void menu() {
        System.out.println("========================");
        System.out.println("        OPTIONS         ");
        System.out.println("========================");
        System.out.println("[A] - Add");
        System.out.println("[B] - Subtract");
        System.out.println("[C] - Multiply");
        System.out.println("[D] - Divide");
        System.out.println("========================");
    }

    public static void input() {
        System.out.print("First Number: ");
        while (!input.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            input.next();
        }
        num1 = input.nextDouble();
        System.out.print("Second Number: ");
        while (!input.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            input.next();
        }
        num2 = input.nextDouble();
    }

    public static double add() {
        return num1 + num2;
    }

    public static double sub() {
        return num1 - num2;
    }

    public static void mul() {
        double product = num1 * num2;
        System.out.println("Multiply method: " + product);
    }

    public static void div() {
        if (num2 == 0) {
            System.out.println("Divide method: undefined (cannot divide by zero)");
            return;
        }
        double quotient = num1 / num2;
        System.out.println("Divide method: " + quotient);
    }

    public static boolean tryAgain() {
        System.out.print("Try another? (y/n): ");
        again = input.next().toLowerCase().charAt(0);
        return again == 'y';
    }

    public static void main(String[] args) {
        boolean repeat;

        do {
            menu();
            input();
            System.out.print("Enter choice: ");
            choice = input.next().toLowerCase().charAt(0);
            switch (choice) {
                case 'a':
                    System.out.println("Add method: " + add());
                    break;
                case 'b':
                    System.out.println("Subtract method: " + sub());
                    break;
                case 'c':
                    mul();
                    break;
                case 'd':
                    div();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            repeat = tryAgain();
        } while (repeat);
        input.close();
        System.out.println("Program ended.");
    }
}